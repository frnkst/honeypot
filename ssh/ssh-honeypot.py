#!/usr/bin/env python2.7
import json
import random
import socket
import sys
import threading
import time

import requests

import paramiko
from kafka import KafkaProducer

producer = KafkaProducer(bootstrap_servers='127.0.0.1:9092')

iplist = {}

#generate keys with 'ssh-keygen -t rsa -f server.key'
HOST_KEY = paramiko.RSAKey(filename='server.key')
SSH_PORT = 2222
LOGFILE = 'logins.txt'  #File to log the user:password combinations to
LOGFILE_LOCK = threading.Lock()


# A fun task would be to move this to a kafka streams application
def get_ip_info(ip):
    if ip not in iplist:
        response = requests.get("http://ip-api.com/json/" + ip)
        response.raise_for_status()
        data = response.json()

        if data['status'] != 'fail':
            iplist[ip] = {
                'city': data['city'],
                'country': data['country'],
                'isp': data['isp']
            }
        else:
            iplist[ip] = {
                'city': 'unknown',
                'country': 'unknown',
                'isp': 'unknown'
            }

    return iplist[ip]


def kafka_publish(ip, username, password):
    ip_info = get_ip_info(ip)

    from datetime import datetime, timezone

# Get the current UTC timestamp
    current_unix_timestamp = time.time()

    data = {
        "username": username,
        "password": password,
        "timestamp": current_unix_timestamp,
        "ip": ip,
        "ipDetails": ip_info
    }
    # Convert the dictionary to a JSON object
    json_data = json.dumps(data)
    num = random.randint(1, 100)

    producer.send('attack', key=bytes("99", "UTF-8"),
                  value=bytes(json_data, "UTF-8"))
    producer.flush()


class SSHServerHandler(paramiko.ServerInterface):
    def __init__(self, client_ip):
        self.client_ip = client_ip
        self.event = threading.Event()

    def check_auth_password(self, username, password):
        kafka_publish(self.client_ip, username, password)

        LOGFILE_LOCK.acquire()
        try:
            logfile_handle = open(LOGFILE, "a")
            print("New login: " + username + ":" + password)
            logfile_handle.write(username + ":" + password + "\n")
            logfile_handle.close()
        finally:
            LOGFILE_LOCK.release()
        return paramiko.AUTH_FAILED

    def get_allowed_auths(self, username):
        return 'password'


def handle_connection(client, addr):
    client_ip = addr[0]
    transport = paramiko.Transport(client)
    transport.add_server_key(HOST_KEY)

    server_handler = SSHServerHandler(client_ip)

    transport.start_server(server=server_handler)

    channel = transport.accept(1)
    if not channel is None:
        channel.close()


def main():
    try:
        server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server_socket.bind(('', SSH_PORT))
        server_socket.listen(100)

        paramiko.util.log_to_file('paramiko.log')

        while (True):
            try:
                client_socket, client_addr = server_socket.accept()
                threading.Thread.start(handle_connection(client_socket, client_addr))
            except Exception as e:
                print("ERROR: Client handling")
                print(e)

    except Exception as e:
        print("ERROR: Failed to create socket")
        print(e)
        sys.exit(1)


main()

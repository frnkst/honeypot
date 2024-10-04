# Start Kafka
docker compose up -d kafka/docker-compose.yml

# Start SSH Honeypot
pip3 install  -r ssh/requirements.txt
python3 ssh/ssh-honeypot.py &


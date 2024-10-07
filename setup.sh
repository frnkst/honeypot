# Start Kafka
docker compose up -d kafka/docker-compose.yml

# Install connector
curl -X POST -H "Content-Type: application/json" --data '{
  "name": "mongodb-sink-connector-attack",
  "config": {
    "connector.class": "com.mongodb.kafka.connect.MongoSinkConnector",
    "tasks.max": "1",
    "topics": "attack",
    "connection.uri": "mongodb://mongo1:30001,mongo2:30002,mongo3:30003/?replicaSet=my-replica-set",
    "database": "honeypot",
    "collection": "attack",
    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "value.converter": "org.apache.kafka.connect.storage.StringConverter",
    "value.converter.schemas.enable": false
  }
}' http://localhost:8083/connectors

# Start SSH Honeypot
pip3 install  -r ssh/requirements.txt
python3 ssh/ssh-honeypot.py &


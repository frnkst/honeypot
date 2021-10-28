# Import KafkaConsumer from Kafka library
from kafka import KafkaConsumer
from json import loads

bootstrap_servers = ['localhost:29092']

# Define topic name from where the message will recieve
topicName = 'login'

# Initialize consumer variable
consumer = KafkaConsumer(topicName,
                         group_id='group1',
                         bootstrap_servers=bootstrap_servers,
                         value_deserializer=lambda x: loads(x.decode('utf-8')))

# Read and print message from consumer
for msg in consumer:
  print("Topic Name=%s,Message=%s"%(msg.topic,msg.value))

# Small python consumer for testing purposes
from kafka import KafkaConsumer
from json import loads

consumer = KafkaConsumer('login',
                         group_id='group1',
                         bootstrap_servers=['localhost:29092'],
                         value_deserializer=lambda x: loads(x.decode('utf-8')))

for msg in consumer:
    print("Topic Name=%s,Message=%s" % (msg.topic, msg.value))

# Honeypot

## TO DO

- Time stats: 15 mins, 1h, 24h, since beginning. Kafka? --> Kafka Streams App
- Attacks per Minute (Attack Rate) --> Kafka Streams App
- Gauge: Heavy Attack ongoing, Medium attack, quiet
  - Write tests         c
- Do proper DDD
- Build and deploy

This works:                         c
https://github.com/UpSync-Dev/docker-compose-mongo-replica-set

Links
https://medium.com/@JosephOjo/mongodb-replica-set-with-docker-compose-5ab95c02af0d

Start mongo with replica set
`docker run --rm -d -p 27017:27017 -h $(hostname) --name mongo mongo:6.0.5 --replSet=dbrs && sleep 5 && docker exec mongo mongosh --quiet --eval "rs.initiate();"`

Connection string for compass:
mongodb://mongo1:30001,mongo2:30002,mongo3:30003/?replicaSet=my-replica-set



## Architecture c

![architecture](./docs/architecture.png)

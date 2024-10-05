# Honeypot

## TO DO

- Write tests
- Do proper DDD
- Send SSE on insert to mongo
- Build and deploy

This works:
https://github.com/UpSync-Dev/docker-compose-mongo-replica-set

Links
https://medium.com/@JosephOjo/mongodb-replica-set-with-docker-compose-5ab95c02af0d

Start mongo with replica set
`docker run --rm -d -p 27017:27017 -h $(hostname) --name mongo mongo:6.0.5 --replSet=dbrs && sleep 5 && docker exec mongo mongosh --quiet --eval "rs.initiate();"`

Connection string for compass:
mongodb://mongo1:30001,mongo2:30002,mongo3:30003/?replicaSet=my-replica-set



## Architecture

![architecture](./docs/architecture.png)

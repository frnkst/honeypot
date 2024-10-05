# Honeypot

## TO DO

- Write tests
- Do proper DDD
- Send SSE on insert to mongo
- Build and deploy
- 

Links
https://medium.com/@JosephOjo/mongodb-replica-set-with-docker-compose-5ab95c02af0d

Start mongo with replica set
`docker run --rm -d -p 27017:27017 -h $(hostname) --name mongo mongo:6.0.5 --replSet=dbrs && sleep 5 && docker exec mongo mongosh --quiet --eval "rs.initiate();"`

## Architecture

![architecture](./docs/architecture.png)

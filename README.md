##Demo project spring security jwt

## Getting started

1) Build dependencies
```
mvn clean install

2) Up database

docker-compose -f ./docker-compose/docker-compose.yml up -d postgres-db-security

3) Up backend auth-service

docker-compose -f ./docker-compose/docker-compose.yml up -d auth-service
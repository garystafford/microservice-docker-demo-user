# microservice-docker-demo-user
#### Introduction
One of a set of Java Spring Boot microservices, for an upcoming post on scaling Spring Boot microservices with the latest Spring and Docker features.

#### Technologies
* Java
* Spring Boot
* Gradle
* MongoDB
* Spring Cloud Config Server
* Spring Cloud Netflix Eureka
* Spring Boot with Docker

#### Commands
Common MongoDB Commands
```bash
mongo # use mongo shell
> show dbs
> use users
> db.user.find()
> db.dropDatabase()
```

Import sample data to MongoDB
```bash
PROJECT_ROOT='/Users/gstaffo/Documents/projects/widget-docker-demo'
mongoimport --db users --collection user --type json --jsonArray \
    --file ${PROJECT_ROOT}/user-service/src/main/resources/data/data.json
```

Build and start service
```bash
# development environment profile
./gradlew clean build && \
  java -jar -Dspring.profiles.active=development \
    build/libs/user-service-0.1.0.jar

# production environment profile
./gradlew clean build && \
  java -jar -Dspring.profiles.active=production \
    build/libs/user-service-0.1.0.jar
```

Build Docker Image of service (do not include profile)
```bash
./gradlew clean build buildDocker --info
```

Test the service
```bash
# create new user document
curl -i -X POST -H "Content-Type:application/json" -d '{
  "firstName": "Max",
  "lastName": "Mustermann",
  "userName": "MadMAX",
  "points": 44,
  "widgets": [
    {
      "product_id": "N212QZOD9B",
      "name": "Pentwist",
      "color": "Gray",
      "size": "Huge",
      "value": 60,
      "preview": "https://s3.amazonaws.com/widgets-microservice-demo/N212QZOD9B.png"
    },
    {
      "product_id": "N43WV5234S",
      "name": "Zapster",
      "color": "Green",
      "size": "Tiny",
      "value": 4,
      "preview": "https://s3.amazonaws.com/widgets-microservice-demo/N43WV5234S.png"
    }
  ]
}' http://localhost:8031/users

# get all widgets
curl http://localhost:8031/users | prettyjson
curl http://localhost:8031/users/search/findByLastName?name=Mustermann | prettyjson
```
_* uses prettyjson Ruby gem_

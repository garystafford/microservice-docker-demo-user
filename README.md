# microservice-docker-demo-user
#### Introduction
One of a set of Java Spring Boot microservices, for an upcoming post on scaling Spring Boot microservices with the latest Docker features.

#### Technologies
* Java
* Spring Boot
* Gradle
* MongoDB
* Spring Cloud Config Server
* Spring Cloud Netflix Eureka

#### Commands
```bash
# drop existing database
mongo
> use users
> db.user.find()
> db.dropDatabase()
```

```bash
# import sample data
mongoimport --db users --collection user --type json --jsonArray \
    --file /Users/gstaffo/Documents/projects/widget-docker-demo/user-service/src/main/resources/data/user_data.json
```

```bash
# build and start service
./gradlew clean build && \
  java -jar -Dspring.profiles.active=development \
    build/libs/user-service-0.0.1-SNAPSHOT.jar

# production
./gradlew clean build && \
  java -jar -Dspring.profiles.active=production \
    build/libs/user-service-0.0.1-SNAPSHOT.jar
```

```bash
# test service
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

curl http://localhost:8031/users | prettyjson
curl http://localhost:8031/users/search/findByLastName?name=Mustermann | prettyjson
```

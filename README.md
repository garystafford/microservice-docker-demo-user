# microservice-docker-demo-user

#### Introduction
One of a set of Java Spring Boot services, for an upcoming post on scaling Spring Boot microservices with the latest Spring and Docker features.

#### Technologies
* Java
* Spring Boot
* Gradle
* MongoDB
* Consul
* Spring Cloud Config Server (migrating to Consul)
* Spring Cloud Netflix Eureka
* Spring Boot with Docker

#### MongoDB
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

#### Build Service
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

#### Test Service
Create new user document
```bash
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
```

Get users
```bash
curl http://localhost:8031/users | prettyjson
curl http://localhost:8031/users/search/findByLastName?name=Mustermann | prettyjson
```

#### Docker
Login to Docker Hub first
```bash
docker login
```

Build the Docker Image containing service jar. The profile will be used to run
 Docker container not create Docker Image
```bash
./gradlew clean build buildDocker
```

Create and run a Docker container
```bash
docker run -e "SPRING_PROFILES_ACTIVE=production" -p 8031:8031 -t garystafford/user-service
```

#### References
* https://github.com/Transmode/gradle-docker

# microservice-docker-demo-user

```bash
./gradlew build
java -jar build/libs/user-0.0.1-SNAPSHOT.jar

curl -i -X POST -H "Content-Type:application/json" -d '{
  "firstName": "Mary",
  "lastName": "Smith",
  "userName": "MPower",
  "points": 100,
  "widgets": [
    {
      "product_id": "N212QZOD9B",
      "name": "Pentwist",
      "color": "Gray",
      "size": "Huge",
      "price": 75,
      "preview": "https://s3.amazonaws.com/widgets-microservice-demo/N212QZOD9B.png"
    },
    {
      "product_id": "N43WV5234S",
      "name": "Zapster",
      "color": "Green",
      "size": "Tiny",
      "price": 3,
      "preview": "https://s3.amazonaws.com/widgets-microservice-demo/N43WV5234S.png"
    }
  ]
}' http://localhost:8031/users

curl http://localhost:8031/users/search/findByLastName?name=Smith
```
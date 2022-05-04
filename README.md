# Getting Started

### Deploying
First build the project and the docker image: 
```bash
./gradlew bootBuildImage --imageName=amaris/ecomerce-test-andy:1.0
``` 

After the build, you can execute:
```bash
docker-compose up -d
```

Use the next command if you want shutdown the application:
```bash
docker-compose down
```

The call to final price request is:
```aidl
[GET] localhost:8080/api/v1/brand/1/product/35455/price?date=2020-06-14T17:00

Response (PriceDto):
    {
        "product_id": 35455,
        "brand_id": 1,
        "price_list": 2,
        "from": "2020-06-14T15:00:00",
        "to": "2020-06-14T18:30:00",
        "final_price": "25,45 €"
    }

```

### Swagger
To access the swagger definitions (openapi), go to the url:
http://localhost:8080/swagger-ui.html

### Postman test runner
Access to [the Postman Collection](https://www.postman.com/red-comet-639518/workspace/amaris/collection/6696700-5f37534f-8d08-4d16-bd4b-456356494f17?action=share&creator=6696700)
and follow the next [Link](https://learning.postman.com/docs/running-collections/working-with-data-files/)
to load the test data (`postman-test-runner.json`) in the runner.

Be sure you have the application running before execute the Postman tests.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/#build-image)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#production-ready)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#web.reactive)
* [Liquibase Migration](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#howto-execute-liquibase-database-migrations-on-startup)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


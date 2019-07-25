# spring-cloud-gateway Demo application

This repository contains the sample code used in my talk at the
[Kotlin User Group Düsseldorf](https://www.meetup.com/de-DE/Dusseldorf-Kotlin-Meetup/) on 2019-07-24. It is a demo
application that uses [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway) as an API Gateway for a
fictional flower shop whose website has an API that consists of three microservices:

* The `bouquet` microservice allowing users to order flower bouquets
* The `inventory` microservice giving insight into the flowers that are available
* The `business` microservice facilitating business orders, e.g. decoration jobs for big events

Of course, because they're demos, the microservices each only expose a `/hello` resource that says hello to the user.

## Requirements

To build and run this application, all you need is a working JDK 11 environment on your machine. If you haven't set that
up yet, I recommend enlisting the services of the world's greatest super hero, [SDKMan](https://sdkman.io/).

## Checking out and running the demo

No fancy docker magic here. These commands check out the code and run the project's four applications (the three
microservices and the API Gateway) in the background.

```bash
git clone https://github.com/tobiasgies/spring-cloud-gateway-demo.git
cd spring-cloud-gateway-demo
./gradlew :bouquet:bootRun &
./gradlew :business:bootRun &
./gradlew :inventory:bootRun &
./gradlew :apigateway:bootRun &
```

The microservices will run on ports `8091-8093`, the API gateway on port `8080`. Let's test that the individual
microservices respond:

```bash
curl http://localhost:8091/bouquet/hello
# Hello from the bouquet controller!
curl http://localhost:8092/business/hello
# Hello from the business controller!
curl http://localhost:8093/inventory/hello
# Hello from the inventory controller!
```

The API gateway will expose all microservices on a single HTTP server, and has a fallback route for any requests that
don't reach one of the microservices:

```bash
curl http://localhost:8080/bouquet/hello
# Hello from the bouquet controller!
curl http://localhost:8080/business/hello
# Hello from the business controller!
curl http://localhost:8080/inventory/hello
# Hello from the inventory controller!
curl http://localhost:8080/whatever
# Go away, you don't know how to use my API.
```

Congratulations, you've successfully run the demo code!

## Notable files

The most important bit of this demo is the `apigateway` sub-project. These are the files that we discussed during the
presentation:

* [RoutingConfiguration](apigateway/src/main/kotlin/de/tobiasgies/apigateway/RoutingConfiguration.kt):
  Main configuration of this project, containing all Spring Cloud Gateway route definitions. I recommend playing around
  with the different Route Predicates (and maybe adding a custom predicate) to get a feeling for how the DSL works.
* [SampleGlobalFilter](apigateway/src/main/kotlin/de/tobiasgies/apigateway/SampleGlobalFilter.kt):
  Contains an explanation for filters, which allow manipulating request and response data. Filters can be applied to
  individual routes or (as in this case) applied to all routes equally by implementing `GlobalFilter`.
* [SampleWebServerCustomizer](apigateway/src/main/kotlin/de/tobiasgies/apigateway/SampleWebServerCustomizer.kt):
  Skeleton for a class that would customize the underlying Netty web server.
* [LocalEndpoints](apigateway/src/main/kotlin/de/tobiasgies/apigateway/LocalEndpoints.kt):
  Contains the API Gateway's local fallback endpoint. Spring Cloud Gateway, underneath it all, is a
  `spring-web-reactive` application, and as such, can contain `@RestController`s like any other Spring web app.
  
## Further reading

* Definitely check out the
  [Spring Cloud Gateway documentation](https://cloud.spring.io/spring-cloud-gateway/spring-cloud-gateway.html). It
  contains a ton of detailed information and examples for routes, predicates, filters and more.
* **I am not the author of Spring Cloud Gateway.** However, if you have questions about this demo application, please
  feel free to [create an issue](https://github.com/tobiasgies/spring-cloud-gateway-demo/issues) or drop me a line. You
  can find ways to contact me [on my website](https://www.tobiasgies.de).
# Synfication

TODO:
Non coding; 
- Postman voor aanroepen
- Startup documentatie & uitsturen (Java Version, docker, Postman/Bruno, etc.)
- V Database (h2) -> Done, Postgres
- V (Dockercompose -> Kafka) -> Automatisch
Coding:
- Feature: Rudimentary first impl. of notificatie 
  - API call voor aanmaken notificatie
  - Notificatie naar topic
  - Verwerking... (TBD)
  - Uitsturen notificatie naar abonnement

Hackaton:
- Reactive?
- Admin UI?

# Before you start

Before checking this project out and running the code, make sure the following software is installed:
- Java JDK 21 (Adoptium OpenJDK)
- Docker Desktop (latest version), if you have installed this already make sure it's up-to-date
- Postman/Bruno/Insomnia (or something else to make http requests)

# DevNotes

Good read on reactive & vert.x: https://quarkus.io/guides/quarkus-reactive-architecture

## Lessons learned
- Use `./mvnw quarkus:add-extension -Dextensions="quarkus-hibernate-orm-panache` & remove-extension
- Dont have your git repo on onedrive ;)
- quarkus:dev does not (mvn) clean!!


## Server stub generator
- OpenAPI spec from: https://github.com/open-zaak/open-notificaties/blob/main/src/openapi.yaml
- Installed latest (unreleased) quarkus openapi server generator: https://github.com/quarkiverse/quarkus-openapi-generator/tree/main (mvn install -DskipTests)
  - Now saved in project -Do this first time!!!!-:
  ```
  cd manualJar
  mvn install:install-file -Dfile=".\quarkus-openapi-generator-server-3.0.0-SNAPSHOT.jar" -DpomFile=".\quarkus-openapi-generator-server-3.0.0-SNAPSHOT.pom"
  mvn install:install-file -Dfile=".\quarkus-openapi-generator-server-deployment-3.0.0-SNAPSHOT.jar" -DpomFile=".\quarkus-openapi-generator-server-deployment-3.0.0-SNAPSHOT.pom"
  mvn install:install-file -Dpackaging=pom -Dfile=".\quarkus-openapi-generator-server-parent-3.0.0-SNAPSHOT.pom" -DpomFile=".\quarkus-openapi-generator-server-parent-3.0.0-SNAPSHOT.pom"
  mvn install:install-file -Dpackaging=pom -Dfile=".\quarkus-openapi-generator-parent-3.0.0-SNAPSHOT.pom" -DpomFile=".\quarkus-openapi-generator-parent-3.0.0-SNAPSHOT.pom"
  ```
- Follow docs: https://docs.quarkiverse.io/quarkus-openapi-generator/dev/server.html

## Starting issues
If: `Caused by: com.github.dockerjava.api.exception.InternalServerErrorException: Status 500: {"message":"failed to set up container networking: driver failed programming external connectivity on endpoint eager_haibt (d99ad5dfcc3c14ee029f257d3ea9a106d5f5fc4ff84c760bdcca96d1239077a7): failed to listen on TCP socket: address already in use"}`
Update docker desktop...



<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>




















Default md below...
_____

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/janfication2-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- OpenAPI Generator - REST Client Generator ([guide](https://docs.quarkiverse.io/quarkus-openapi-generator/dev/index.html)): Generation of Rest Clients based on OpenAPI specification files
- Messaging - Kafka Connector ([guide](https://quarkus.io/guides/kafka-getting-started)): Connect to Kafka with Reactive Messaging

## Provided Code

### Messaging codestart

Use Quarkus Messaging

[Related Apache Kafka guide section...](https://quarkus.io/guides/kafka-reactive-getting-started)


### OpenAPI Generator Codestart

Start to code with the OpenAPI Generator extension.

[Related guide section...](https://docs.quarkiverse.io/quarkus-openapi-generator/dev/index.html)

## Requirements

If you do not have added the `io.quarkus:quarkus-rest-client-jackson` or `io.quarkus:quarkus-rest-client-reactive-jackson` extension in your project, add it first:

Remember, you just need to add one of them, depending on your needs.

### REST Client Jackson:

Quarkus CLI:

```bash
quarkus ext add io.quarkus:quarkus-rest-client-jackson
```

Maven:
```bash
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client-jackson"
```

Gradle:

```bash
./gradlew addExtension --extensions="io.quarkus:quarkus-rest-client-jackson"
```

or

### REST Client Reactive Jackson:

Quarkus CLI:

```bash
quarkus ext add io.quarkus:quarkus-rest-client-reactive-jackson
```

Maven:

```bash
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client-reactive-jackson"
```

Gradle:

```bash
./gradlew addExtension --extensions="io.quarkus:quarkus-rest-client-reactive-jackson"
```
### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)


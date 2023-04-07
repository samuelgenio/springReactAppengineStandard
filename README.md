# Multi Module Spring React Appengine Standard

This sample shows how to deploy a [Spring Boot](https://spring.io/projects/spring-boot)
application to Google App Engine standard.

See the [Quickstart for Java in the App Engine Standard Environment][ae-docs] for more
detailed instructions.

[ae-docs]: https://cloud.google.com/appengine/docs/standard/java11/quickstart

## Setup

See [Prerequisites](../README.md#Prerequisites).


#### In this project you will find:
* Java 11 with gradle
* kotlin based project
* Multi Module Spring (application, controller, domain, frontend and root-project)
* deploy a jar with backend and frontend together for Appengine standard environment

### What you need installed to run this project:
* [SDK 11](https://sdkman.io/install)
* [Gradle](https://gradle.org/install/) `sdk install gradle`

## Setting up development environment:

1. Run Backend
```shell
 $ ./gradlew bootrun
```
2. Run Frontend

```shell
 $ cd frontend/
 $ npm install
 $ npm run dev
```

## How to deploy 

1. Set up project id in `/root-project/build.gradle`
```
    projectId = "my-project-id"
```

2. Run 
```shell
    ./gradlew appengineDeploy
```

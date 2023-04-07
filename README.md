# Multi Module Spring React Appengine Standard

In this project you will find:
* Java 11
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

1. Set up project id in `/root-project/build.gradlew`
```
    projectId = "my-project-id"
```

2. Run 
```shell
    ./gradlew appengineDeploy
```
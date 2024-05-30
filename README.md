# DVP

> A simple Java project to procces ticket and users 
> Developed by Robinson Turriago

## Prerequisites

You will need the following things properly installed on your computer.
Recommended versions java 17 and gradle 8.7

* [Git](http://git-scm.com/)
* [Gradle](https://gradle.org//)
* [Docker](https://docs.docker.com/)

## Installation

This Java project use [Gradle](https://gradle.org//), 
is an open-source build automation tool that is designed to be flexible enough to build almost any type of software.

* Execute: `git clone https://github.com/Robin96hood/dvp.git`.
* Change into the new directory `cd dvp/complete/`

## For Run api use
```bash
gradle clean build
java -jar build/libs/graphql-server-0.0.1-SNAPSHOT.jar
```

## For Run api with docker use
```bash
gradle clean build
docker build -t graphql-server-0.0.1 .
docker run --name "graphql-server-0.0.1" -it graphql-server-0.0.1
```

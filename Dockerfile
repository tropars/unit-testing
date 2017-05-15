FROM debian:latest

RUN apt-get update && apt-get install -y maven

WORKDIR /tmp/

COPY src ./
COPY pom.xml ./

CMD mvn package

FROM maven:3.5-jdk-8 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
RUN ls
RUN cd usr
RUN ls
RUN cd src
RUN ls
RUN cd app
RUN pwd ls
COPY target/*.jar /usr/src/app
ENTRYPOINT ["java","-jar","/home.jar"]

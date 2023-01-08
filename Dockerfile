#BUILD STAGE

FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app/pom.xml
RUN mvn -f /home/app/pom.xml -DskipTests clean package

#PACKAGE STAGE

FROM openjdk:8u212-jdk-slim
COPY --from=build /home/app/target/bookmyturf.jar /home/bookmyturf.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/home/bookmyturf.jar"]
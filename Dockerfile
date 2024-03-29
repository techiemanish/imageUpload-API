#Author: techiemanish
#Github: https://github.com/techiemanish

FROM maven:latest AS build

COPY src /usr/src/app/src

COPY pom.xml /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:17

COPY --from=build /usr/src/app/target/photo-upload-0.0.1-SNAPSHOT.jar /usr/app/photo-upload-0.0.1-SNAPSHOT.jar

EXPOSE 8181

CMD ["java", "-jar", "/usr/app/photo-upload-0.0.1-SNAPSHOT.jar"]
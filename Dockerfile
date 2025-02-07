# imagem base do OpenJDK 17
FROM openjdk:17-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/desafio-itau-spring-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

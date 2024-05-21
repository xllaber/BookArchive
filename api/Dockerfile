FROM eclipse-temurin/17-jdk-alpine

LABEL maintainer="xllaber7@gmail.com"

VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/BookArchive-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT["jave", "-Xmx2048m", "-jar", "-Dspring.profiles.active=${spring_profile}", "/app.jar"]
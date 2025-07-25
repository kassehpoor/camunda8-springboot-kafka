FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/email-service*.jar app.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "app.jar"]

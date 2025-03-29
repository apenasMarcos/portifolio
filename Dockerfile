FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/br.com.marcos-0.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080

FROM eclipse-temurin:21

WORKDIR /app

COPY target/gift-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
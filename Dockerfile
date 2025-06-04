# Этап сборки (используем Maven для сборки)
FROM maven:3.9.9 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Этап запуска (используем только JAR)
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/gift-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
# Сборка
FROM eclipse-temurin:21 AS builder
WORKDIR /app
COPY . .
RUN apt-get update && \
    apt-get install -y maven
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Финальный образ
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=builder /app/target/gift_bot-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
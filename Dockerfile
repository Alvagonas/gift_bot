# Сборка
FROM eclipse-temurin:21 AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Финальный образ
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=builder /app/target/gift_bot-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
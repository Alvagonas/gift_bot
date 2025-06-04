# Используем официальный образ с Java 21
FROM eclipse-temurin:21

# Рабочая директория
WORKDIR /app

# Копируем собранный JAR (предварительно собранный через Maven/Gradle)
COPY target/gift_bot-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт приложения
EXPOSE 8080

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
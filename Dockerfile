# Используем официальный образ OpenJDK 21
FROM eclipse-temurin:21-jdk

# Создаем рабочую директорию
WORKDIR /app

# Копируем Maven wrapper и pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Копируем исходный код
COPY src ./src

# Собираем приложение
RUN ./mvnw package -DskipTests

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "target/gift-service-0.0.1-SNAPSHOT.jar"]
FROM gradle:8.1.1-jdk17 AS build
WORKDIR /app
COPY build.gradle gradlew ./
COPY gradle/ ./gradle/
RUN ./gradlew dependencies
COPY src/ ./src/
RUN ./gradlew build -x test

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
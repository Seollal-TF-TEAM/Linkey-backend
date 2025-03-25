# 🔹 1단계: Gradle 빌드
FROM gradle:8.1.1-jdk17 AS build
WORKDIR /app

# Gradle 캐시를 활용하기 위해 먼저 종속성 관련 파일 복사
COPY build.gradle settings.gradle gradlew ./
COPY gradle/ ./gradle/

# 🔹 종속성만 먼저 다운로드하여 캐시 적용
RUN ./gradlew dependencies

# 소스 코드 복사 후 빌드 실행 (캐시 최적화)
COPY src/ ./src/
RUN ./gradlew build -x test

# 🔹 2단계: 경량화된 실행 환경
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드된 JAR 파일을 자동으로 찾아서 복사
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

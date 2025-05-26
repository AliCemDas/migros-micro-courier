FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY config-service/target/config-service-1.0-SNAPSHOT.jar config-service.jar

ENTRYPOINT ["java", "-jar", "config-service.jar", "--spring.profiles.active=docker"]

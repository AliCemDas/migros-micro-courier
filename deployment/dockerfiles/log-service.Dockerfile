FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY log-service/target/log-service-0.0.1-SNAPSHOT.jar log-service.jar

ENTRYPOINT ["java", "-jar", "log-service.jar", "--spring.profiles.active=docker"]

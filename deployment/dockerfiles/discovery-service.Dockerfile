FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY discovery-service/target/discovery-service-0.0.1-SNAPSHOT.jar discovery-service.jar

ENTRYPOINT ["java", "-jar", "discovery-service.jar", "--spring.profiles.active=docker"]

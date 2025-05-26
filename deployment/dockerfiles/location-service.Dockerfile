FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY location-service/target/location-service-0.0.1-SNAPSHOT.jar location-service.jar

ENTRYPOINT ["java", "-jar", "location-service.jar", "--spring.profiles.active=docker"]

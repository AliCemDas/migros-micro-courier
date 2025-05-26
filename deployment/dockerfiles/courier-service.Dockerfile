FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY courier-service/target/courier-service-0.0.1-SNAPSHOT.jar courier-service.jar

ENTRYPOINT ["java", "-jar", "courier-service.jar", "--spring.profiles.active=docker"]

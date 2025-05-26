FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY auth-service/target/auth-service-0.0.1-SNAPSHOT.jar auth-service.jar

ENTRYPOINT ["java", "-jar", "auth-service.jar", "--spring.profiles.active=docker"]

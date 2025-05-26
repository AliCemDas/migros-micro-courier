FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY store-service/target/store-service-0.0.1-SNAPSHOT.jar store-service.jar

ENTRYPOINT ["java", "-jar", "store-service.jar", "--spring.profiles.active=docker"]

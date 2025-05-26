FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

COPY gateway-service/target/gateway-service-0.0.1-SNAPSHOT.jar gateway-service.jar

ENTRYPOINT ["java", "-jar", "gateway-service.jar", "--spring.profiles.active=docker"]

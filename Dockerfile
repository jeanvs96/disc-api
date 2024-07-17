FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar disc-api.jar
EXPOSE 8080
CMD ["java", "-jar", "disc-api.jar"]
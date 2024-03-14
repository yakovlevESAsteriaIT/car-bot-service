FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} lisarulit-car-bot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/lisarulit-car-bot.jar"]
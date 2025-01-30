FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/bond-tracking-0.0.1-SNAPSHOT.jar /app/bond-tracking.jar
ENTRYPOINT ["java", "-jar", "bond-tracking.jar"]


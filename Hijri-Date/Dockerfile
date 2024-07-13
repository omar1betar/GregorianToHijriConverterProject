# Use a base image with JDK pre-installed (Alpine Linux variant for a smaller image)
FROM openjdk:22-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container at /app
COPY target/Hijri-Date-0.0.1-SNAPSHOT.jar /app/ijri-Date-0.0.1-SNAPSHOT.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8001

# Specify the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "ijri-Date-0.0.1-SNAPSHOT.jar"]

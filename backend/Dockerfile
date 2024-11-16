# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file to the container
COPY pom.xml .

# Copy the source code to the container
COPY src ./src

# Build the application (Maven wrapper should be included in your project)
RUN apt-get update && apt-get install -y maven && \
    mvn -f pom.xml clean package -DskipTests

# Expose the port that the app runs on
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "target/CarApp-0.0.1-SNAPSHOT.jar"]

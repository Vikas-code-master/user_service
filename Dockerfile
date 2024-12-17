# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/userservice-0.0.1-SNAPSHOT.jar /app/userservice-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on (update as per your app's configuration)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/userservice-0.0.1-SNAPSHOT.jar"]

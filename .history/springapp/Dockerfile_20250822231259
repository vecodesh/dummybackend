# Use OpenJDK image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file from target folder to container
COPY target/*.jar app.jar

# Expose port (Render assigns PORT env variable)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]

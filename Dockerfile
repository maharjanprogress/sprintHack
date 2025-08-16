# Stage 1: Build the application using Maven with JDK 21
# This stage uses a full JDK 21 and Maven to build the JAR file.
# The correct image name is 'maven' with the '3.9.6-eclipse-temurin-21' tag.
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml to leverage Docker layer caching
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download all project dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the application's source code
COPY src ./src

# Package the application into an executable JAR, skipping tests
RUN ./mvnw package -DskipTests

# Stage 2: Create the final, smaller production image with JRE 21
# This stage uses a lightweight Java 21 Runtime Environment.
# The correct image is 'eclipse-temurin' with the '21-jre' tag for a smaller footprint.
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the executable JAR from the 'builder' stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the application runs on (from your application.properties)
EXPOSE 9030

# Set the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
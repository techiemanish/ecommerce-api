#Author: techiemanish
#Github: https://github.com/techiemanish

# Fetching latest version of Java, We are using Java 17 in our project.
FROM openjdk:17

# Setting up container work directory
WORKDIR /app

# Copying the jar file into our app
COPY . /app

# Exposing the Application port 5000
EXPOSE 5000

# Starting the application
CMD ["java", "-jar", "ecommerce-0.0.1-SNAPSHOT.jar"]
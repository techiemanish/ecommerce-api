#Author: techiemanish
#Github: https://github.com/techiemanish

#Maven Build
FROM maven:latest AS build

COPY src /usr/src/app/src

COPY pom.xml /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package

# Fetching latest version of Java, We are using Java 17 in our project.
FROM openjdk:17

COPY --from=build /usr/src/app/target/ecommerce-0.0.1-SNAPSHOT.jar /usr/app/ecommerce-0.0.1-SNAPSHOT.jar
# Exposing the Application port 5000
EXPOSE 5000

# Starting the application
CMD ["java", "-jar", "/usr/app/ecommerce-0.0.1-SNAPSHOT.jar"]
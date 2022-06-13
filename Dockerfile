FROM maven:3.8.5-openjdk-17-slim@sha256:502e781d39f0b40fbd02eb23f5b7663618b76ba52034da218c64e92f6c5647be
WORKDIR /app
EXPOSE 8080
COPY pom.xml .
LABEL version="1.0"
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests
CMD mvn spring-boot:run

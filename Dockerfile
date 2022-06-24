FROM maven:3.8.5-openjdk-17-slim@sha256:502e781d39f0b40fbd02eb23f5b7663618b76ba52034da218c64e92f6c5647be as builder
WORKDIR /app
COPY pom.xml .
COPY flyway-8.5.9 ~/
LABEL version="1.0"
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests


FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 8080:8080
COPY --from=builder /app/target/fleet_management_api-0.0.1-SNAPSHOT.jar ./fleet_management_api.jar
CMD java -jar ./fleet_management_api.jar


FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

COPY .mvn .mvn
COPY mvnw ./
COPY pom.xml ./
COPY src/ src

# mvn -N io.takari:maven:wrapper - update mvnw
RUN ./mvnw clean package spring-boot:repackage

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=builder /app/target/Shop_store_module.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
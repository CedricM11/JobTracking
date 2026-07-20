# ---------- Build Stage ----------
FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw ./
COPY pom.xml ./

RUN chmod +x mvnw
RUN ./mvnw -B dependency:go-offline

COPY src ./src

RUN ./mvnw -B clean package -DskipTests

# ---------- Runtime Stage ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]
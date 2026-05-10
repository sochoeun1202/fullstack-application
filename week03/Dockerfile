# =========================
# Stage 1: Build
# =========================
FROM gradle:8.10-jdk21 AS build

WORKDIR /app

# Copy gradle files first for better layer caching
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle

# Download dependencies
RUN ./gradlew dependencies --no-daemon || true

# Copy source code
COPY src src

# Build application
RUN ./gradlew clean bootJar --no-daemon -x test

# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:21-jre-jammy

# Create non-root user
RUN useradd -r -u 1001 spring

WORKDIR /app

# Copy jar
COPY --from=build /app/build/libs/*.jar app.jar

# Use non-root user
USER spring:spring

# JVM optimization for containers
ENV JAVA_OPTS="-XX:+UseContainerSupport \
-XX:MaxRAMPercentage=75 \
-XX:+ExitOnOutOfMemoryError"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
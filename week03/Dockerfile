# =========================
# Stage 1: Build
# =========================
FROM gradle:8.10-jdk21 AS build

WORKDIR /app

COPY gradlew *.gradle ./
COPY gradle gradle

RUN --mount=type=cache,target=/home/gradle/.gradle \
    ./gradlew buildEnvironment --no-daemon

COPY src src

RUN --mount=type=cache,target=/home/gradle/.gradle \
    ./gradlew clean bootJar --no-daemon -x test

# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:21-jre-jammy

# Create a system user for security
RUN useradd -r -u 1001 spring

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

RUN chown spring:spring /app

USER 1001

# JVM optimization for containers
ENV JAVA_OPTS="-XX:+UseContainerSupport \
-XX:MaxRAMPercentage=75 \
-XX:+ExitOnOutOfMemoryError"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

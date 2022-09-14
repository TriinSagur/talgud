FROM gradle:jdk11 as builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle clean build -x test --stacktrace

FROM openjdk:11-jre-slim as finalApp

ENTRYPOINT ["sudo", "mkdir", "/app/"]

WORKDIR app

COPY --from=builder /home/gradle/src/build/libs/talgud-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/talgud-0.0.1-SNAPSHOT.jar"]
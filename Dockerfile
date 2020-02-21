FROM maven:3.6-jdk-8 AS MAVEN_BUILD
MAINTAINER Luong Bach
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/InterviewRestApi-0.0.1.jar /app/
ENTRYPOINT ["java", "-jar", "InterviewRestApi-0.0.1.jar"]
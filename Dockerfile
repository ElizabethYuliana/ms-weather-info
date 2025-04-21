ARG MAVEN_VERSION=3.9.6-eclipse-temurin-21-alpine
ARG JDK_VERSION=21-jre-alpine
ARG BASE_PATH=/app

FROM maven:${MAVEN_VERSION} AS builder

ARG BASE_PATH
WORKDIR ${BASE_PATH}

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:${JDK_VERSION}

ARG BASE_PATH
WORKDIR ${BASE_PATH}

COPY --from=builder ${BASE_PATH}/target/*.jar app.jar

ARG PORT_APP=8080
ENV PORT=${PORT_APP}
EXPOSE $PORT

CMD ["java", "-jar", "app.jar"]

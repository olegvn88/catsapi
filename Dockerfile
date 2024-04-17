FROM alpine:3.19

RUN apk add openjdk17 && apk cache clean
COPY target/cats-0.0.1.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
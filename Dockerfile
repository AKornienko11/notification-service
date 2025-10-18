FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/notification-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

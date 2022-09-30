FROM openjdk:17-jre-slim-buster
COPY target/bookApp-0.0.1-SNAPSHOT.jar bookApp.jar
ENTRYPOINT ["java","-jar","/bookApp.jar"]
FROM ubuntu:18.04
RUN apt update && apt install -y default-jdk
COPY target/restful-web-services-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
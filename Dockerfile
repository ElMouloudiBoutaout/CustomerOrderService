FROM openjdk:17-alpine
COPY ./target/customerOrder-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "customerOrder-0.0.1-SNAPSHOT.jar"]
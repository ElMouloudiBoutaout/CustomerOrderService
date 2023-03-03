FROM adoptopenjdk:17-jre-hotspot
COPY ./target/myapp.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "myapp.jar"]
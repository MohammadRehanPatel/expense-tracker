FROM amazoncorretto:21

WORKDIR /app

COPY /target/et-bff-service-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar","--spring.profiles.active=docker"]
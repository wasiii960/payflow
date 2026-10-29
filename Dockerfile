FROM eclipse-temurin:21-jre
WORKDIR /app
ENV APP_ENV=dev
COPY target/payflow-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

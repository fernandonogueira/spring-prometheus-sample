FROM openjdk:8-jre-alpine

ADD target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

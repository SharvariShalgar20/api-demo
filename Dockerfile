FROM eclipse-temurin:21-jre-alpine
COPY target/crud-demo.jar crud-demo.jar
ENTRYPOINT ["java", "-jar", "crud-demo.jar"]
FROM eclipse-temurin:21
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} api-publica-0.0.1.jar
ENTRYPOINT ["java","-jar","/api-publica-0.0.1.jar"]
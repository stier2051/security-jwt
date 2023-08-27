#builder
FROM amazoncorretto:17-alpine as builder
ARG JAR_FILE=/home/runner/.m2/repository/kz/mun/security-jwt/0.0.1-SNAPSHOT/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract
ENV TZ Asia/Almaty

#docker
FROM amazoncorretto:17-alpine
COPY --from=builder dependencies/ ./
RUN true
COPY --from=builder snapshot-dependencies/ ./
RUN true
COPY --from=builder spring-boot-loader/ ./
RUN true
COPY --from=builder application/ ./
ENTRYPOINT ["java", "-jar", "/application.jar"]


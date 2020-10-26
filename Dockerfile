FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/vivek1082/platform9.git (1)

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/platform9 app (2)
RUN mvn install (3)

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=1 /app/target/diwalibulbs-0.0.1-SNAPSHOT.jar /app (4)
EXPOSE 8080
CMD ["java -jar diwalibulbs-0.0.1-SNAPSHOT.jar"]
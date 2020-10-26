FROM alpine/git as builder
WORKDIR /app
RUN git clone https://github.com/vivek1082/platform9.git 

FROM maven:3.5-jdk-8-alpine app as vivek
WORKDIR /app
COPY --from=builder /app/platform9 
RUN mvn install 

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=vivek /app/target/diwalibulbs-0.0.1-SNAPSHOT.jar /app 
EXPOSE 8080
CMD ["java -jar diwalibulbs-0.0.1-SNAPSHOT.jar"]
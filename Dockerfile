#Where we start
FROM openjdk:12-alpine AS builder

#Get APK up to date
RUN apk update && apk upgrade


#Git
RUN apk add git
RUN git clone --branch master https://github.com/vivek1082/platform9.git /platform9Git


# Build release image
FROM openjdk:12-alpine



#Copy result
COPY   /platform9/target/diwalibulbs-0.0.1-SNAPSHOT.jar app.jar

#Add user and group for running as unprivileged user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

#Define how to start
ENTRYPOINT ["java", "-jar", "app.jar"]
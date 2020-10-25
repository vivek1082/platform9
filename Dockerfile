#Where we start
FROM openjdk:12-alpine AS builder

#Get APK up to date
RUN apk update && apk upgrade

#Install Maven
RUN apk add maven

#Git
RUN apk add git
RUN mkdir /platform9Git
RUN gh repo clone vivek1082/platform9 /platform9Git

#Build
RUN mvn -f /platform9Git clean install

# Build release image
FROM openjdk:12-alpine

#Copy result
WORKDIR /Executables
COPY --from=builder /platform9/target/diwalibulbs-0.0.1-SNAPSHOT.jar .

#Add user and group for running as unprivileged user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

#Define how to start
ENTRYPOINT ["java", "-jar", "diwalibulbs-0.0.1-SNAPSHOT.jar"]
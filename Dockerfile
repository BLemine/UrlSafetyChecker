FROM gradle:7-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar

FROM openjdk:8-jre-slim
EXPOSE 8080


RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/urlSafetyChecker-0.0.1-SNAPSHOT.jar

CMD ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/urlSafetyChecker-0.0.1-SNAPSHOT.jar", "--googleApiKey=AIzaSyAKBkcNNeTCgYId3qo8E5fizYB3SC8mk8I"]
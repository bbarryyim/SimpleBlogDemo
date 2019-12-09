FROM java:8-jdk-alpine
COPY ./target/SimpleBlogDemo-0.0.1-SNAPSHOT.jar /usr/app/simpleblogdemo/
WORKDIR /usr/app/simpleblogdemo/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "SimpleBlogDemo-0.0.1-SNAPSHOT.jar"]
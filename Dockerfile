FROM openjdk
COPY ./target/demo-0.0.1-SNAPSHOT.jar /demo.jar
ENTRYPOINT ["java", "-jar", "/demo.jar"]
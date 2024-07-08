FROM openjdk:22
ADD target/sms.jar sms.jar
ENTRYPOINT ["java", "-jar", "sms.jar"]
EXPOSE 5000
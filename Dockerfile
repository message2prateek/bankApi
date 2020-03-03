FROM openjdk:8
COPY ./build/libs/bankApi-1.1-SNAPSHOT.jar /usr/src/bankApi
WORKDIR /usr/src/bankApi
CMD ["java", "-jar", "bankApi-1.1-SNAPSHOT.jar"]
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=D:/work/workspaces/MBT/mbt-helper/mbt-elastic/mbt-elastic-service/target/*.jar
COPY ${JAR_FILE} mbt-service.jar
ENTRYPOINT ["java","-jar","/mbt-service.jar"]
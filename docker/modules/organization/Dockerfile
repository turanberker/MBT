FROM openjdk:11
VOLUME /tmp
COPY organization-service-1.0.0.jar organization-service.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/organization-service.jar"]
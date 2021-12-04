FROM openjdk:11
VOLUME /tmp
COPY mbt-elastic-service-1.0.0.jar mbt-elastic.jar
EXPOSE 8100
ENTRYPOINT ["java","-jar","/mbt-elastic.jar"]
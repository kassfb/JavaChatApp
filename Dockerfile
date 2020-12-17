#docker run -t -e DB_SERVER="10.0.2.15" -e DB_NAME="analog" -e DB_PORT='5432' -e DB_USER='tr' -e DB_PASSWORD='tr' -p 8099:8099 <image id or path>
FROM openjdk:11-jdk-slim
COPY /build/libs/lr4-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","lr4-0.0.1-SNAPSHOT.jar"]
CMD ["--help"]
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=prod
ENV DB_SERVER=""
ENV DB_PORT=""
ENV DB_NAME=""
ENV DB_USER=""
ENV DB_PASSWORD=""
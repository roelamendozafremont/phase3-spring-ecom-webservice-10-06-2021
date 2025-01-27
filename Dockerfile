FROM openjdk:8-jdk
COPY ./target/phase3-spring-ecom-webservice-10-06-2021-0.0.1-SNAPSHOT.jar phase3-spring-ecom-webservice-10-06-2021-0.0.1-SNAPSHOT.jar
CMD ["java" ,"-jar","phase3-spring-ecom-webservice-10-06-2021-0.0.1-SNAPSHOT.jar"]


#RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers


# Build Jar from spring boot appln
# mvn clean package
#-> Create a image for springboot webservice
# -->  Dockerfile
#  - -> docker image build -t <imagetagname> .

#-> run container by using custom image
# -> docker container run  --name <ecom-web-service> -p 8081:8081 -d <ecom-webservice>


#-> verify log 
#  -> docker container log <container-name>

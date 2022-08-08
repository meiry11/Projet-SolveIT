#
# Create the Java img for Docker
#
# Spring profile options are in docker-compose.yml file
#

FROM maven:3.8.5-jdk-11
WORKDIR /en01.junit.banque

COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src

# We do not want the TU to be played here
RUN mvn clean install -Dmaven.test.skip=true
CMD mvn spring-boot:run
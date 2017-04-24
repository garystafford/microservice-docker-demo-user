FROM openjdk:8u121-jdk-alpine
LABEL maintainer "Gary A. Stafford <garystafford@rochester.rr.com>"
ENV REFRESHED_AT 2017-04-17
VOLUME /tmp
EXPOSE 8030
RUN set -ex \
  && apk update \
  && apk upgrade \
  && apk add git
RUN mkdir /user \
  && git clone --depth 1 --branch build-artifacts \
      "https://github.com/garystafford/microservice-docker-demo-user.git" /user \
  && cd /user \
  && mv user-service-*.jar user-service.jar
ENV JAVA_OPTS=""
CMD [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "user/user-service.jar" ]

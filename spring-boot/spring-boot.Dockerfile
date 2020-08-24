FROM java:8
    
MAINTAINER zenghm zenghaiming2015@163.com

ADD /target/spring-boot-1.0-SNAPSHOT.jar /usr/src/app/spring-boot-1.0-SNAPSHOT.jar

WORKDIR /usr/src/app

##RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
##&& echo 'Asia/Shanghai' >/etc/timezone

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-boot-1.0-SNAPSHOT.jar"]
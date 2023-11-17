FROM openjdk:8-jre-slim
WORKDIR /educacaoGamificada
COPY target/*.war /educacaoGamificada/educacaoGamificada-0.0.1-SNAPSHOT.war
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar educacaoGamificada-0.0.1-SNAPSHOT.war




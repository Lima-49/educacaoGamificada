FROM openjdk:8-jre-slim
WORKDIR /educacaoGamificada
COPY target/*.war /educacaoGamificada/educacaoGamificada-3.2.0-SNAPSHOT.war
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar educacaoGamificada-3.2.0-SNAPSHOT.war




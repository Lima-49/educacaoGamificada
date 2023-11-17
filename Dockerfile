FROM openjdk:11
WORKDIR /educacaoGamificada
COPY target/*.war /educacaoGamificada/educacaoGamificada-0.0.1-SNAPSHOT.war
EXPOSE 9090
CMD java -jar educacaoGamificada-0.0.1-SNAPSHOT.war

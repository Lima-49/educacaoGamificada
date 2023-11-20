FROM openjdk:17

# Set the working directory in the container
WORKDIR /educacaoGamificada

# Copy the JAR file into the container at /educacaoGamificada
COPY target/*.war /educacaoGamificada/educacaoGamificada-0.0.1-SNAPSHOT.war

# Expose the port that your application will run on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "educacaoGamificada-0.0.1-SNAPSHOT.war"]
FROM openjdk:19
WORKDIR /app
COPY Serveur.jar /app
CMD ["java", "-jar", "Serveur.jar"]

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY pom.xml mvnw* /app/
COPY . /app
RUN ./mvnw -q -DskipTests package || mvn -q -DskipTests package
EXPOSE 8081
ENTRYPOINT ["java","-jar","target/product-service-0.0.1-SNAPSHOT.jar"]

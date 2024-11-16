FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM maven:3-openjdk-17-slim
COPY --from=build /target/CAREXPO-0.0.1-SNAPSHOT.jar CAREXPO.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","CAREXPO.jar"]
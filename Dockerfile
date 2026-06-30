# --- Etapa 1: Compilación ---
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar el POM y descargar las dependencias (optimiza la caché)
COPY "pom.xml" .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar el archivo JAR omitiendo los tests para acelerar el build
COPY src ./src
RUN mvn clean package -DskipTests

# --- Etapa 2: Ejecución ---
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copiar el JAR compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de Spring Boot
EXPOSE 8080

# Ejecutar la aplicación pasando variables de entorno para la base de datos
ENTRYPOINT ["java", "-jar", "app.jar"]
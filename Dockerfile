
# Get the image
FROM eclipse-temurin:21-jdk-alpine-3.20
# Create the directory
WORKDIR /app
# Copy the necesary files
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
# Download the dependencies
RUN gradle build -x test --no-daemon || return 0
# Copy the source
COPY src ./src
# Build the jar
RUN gradle clean bootJar --no-daemon

# Create the final image
FROM eclipse-temurin:21-jdk-alpine-3.20
# Create the directory
WORKDIR /app
# Copy the generated jar in the building
COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

# Move to the directory
# cd C:/Projects/News/ms-news

# Construir la imagen
# docker build -t "ms-news-img:1.0.0" . --no-cache

# Ejecutar el contenedor
# docker run --name "ms-news-container" -p 8080:8080 "ms-news-img:1.0.0"

# Delete the container
# docker container rm -f "ms-news-container"

# Delete the image
# docker image rm "ms-news-img:1.0.0"
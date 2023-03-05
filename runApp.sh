#!/bin/bash

# Build the application using Maven
mvn clean package

# Build the Docker image

# Start the application and its dependencies using Docker Compose
docker-compose up
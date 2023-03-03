#!/bin/bash

# Build the application using Maven
mvnd clean package

# Build the Docker image
docker build -t my-app .

# Start the application and its dependencies using Docker Compose
docker-compose up

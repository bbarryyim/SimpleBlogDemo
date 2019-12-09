#!/usr/bin/env bash

CONTAINER_NAME=simple-blog-demo
echo -"\nSetting docker container name as ${CONTAINER_NAME}\n"

IMAGE_NAME=${CONTAINER_NAME}:dev
echo -"\nSet docker image name as ${IMAGE_NAME}\n"
PORT=8080
echo -"Set docker image PORT to ${PORT}\n"

echo -"Create target jar...\n"
mvn clean package

echo -"\nStop running Docker containers with image tag ${CONTAINER_NAME}, and remove them...n"
docker stop $(docker ps -a | grep ${CONTAINER_NAME} | awk '{print $1}')
docker rm $(docker ps -a | grep ${CONTAINER_NAME} | awk '{print $1}')

echo -"\nDocker build image with name ${IMAGE_NAME}...\n"
docker build -t ${IMAGE_NAME} -f Docker/Dockerfile .

echo -"\nStart Docker container of the image ${IMAGE_NAME} with name ${CONTAINER_NAME}...\n"
docker run --rm -i -p ${PORT}:${PORT} \
    --name ${CONTAINER_NAME} \
    ${IMAGE_NAME}
# How to start app

## Build docker image
1. mvn clean package
2. docker build -t egoryakovlevacc22/lisarulit-car-bot:latest .
3. docker run -p 8080:8443 egoryakovlevacc22/lisarulit-car-bot:0.0.3

## Run docker-compose
1. docker-compose rm -f
2. docker-compose up --build

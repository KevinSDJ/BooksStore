#!/bin/bash
echo "me da fiaca escribrir cada rato estos comandos ,aa";
docker run -d -p 5432:5432 -it --rm -e POSTGRES_USER=kevin -e POSTGRES_PASSWORD=1997 -e POSTGRES_DB=bookdb postgres;
./mvnw spring-boot:run

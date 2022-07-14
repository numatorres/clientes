Para construir imagen Docker ejecutar desde la línea de comandos:

en Linux:

sudo docker image build -t clientes -f Dockerfile .

en Windows:

docker image build -t clientes -f Dockerfile .



Para ejecutar la aplicación en Docker:

en Linux:

sudo docker container run --rm -it -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 clientes

en Windows:
docker container run --rm -it -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 clientes

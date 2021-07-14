Instruções para "construir" as imagens com os Dockerfiles:

- No WSL mudar diretório para "src" do nosso projecto - 

Server: 
docker build --file server.Dockerfile --tag server .

Clinte:
docker build --file client.Dockerfile --tag client .

Intrusões para iniciar os containers:

criar uma rede no docker com:
docker network create grupo6

Server:
docker run --rm --network grupo6 --hostname server --name server -v $(pwd):/app -it server

Clinte:
docker run --rm --network grupo6 --hostname client --name client -v $(pwd):/app -it client



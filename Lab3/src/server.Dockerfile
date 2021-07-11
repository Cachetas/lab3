FROM openjdk:15-slim-buster
RUN apt-get update ; apt-get install -y iproute2
WORKDIR /app
CMD ["sh","-c", "cd Application && javac ServerProgram.java MathServerClass.java MathServer.java && cd .. && java Application.ServerProgram"]

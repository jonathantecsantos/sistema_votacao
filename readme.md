Blockchain Sawtooth para sistema de votação.

Execução:

1 - Inicializar o projeto na IDE

2 - Inicializar o Docker

3 - Acessar o arquivo docker-compose.yml no projeto e executar o comando no CMD:
docker-compose -f sawtooth-default.yaml up

4 - Acessar a pasta blockchai-api do projeto e executar o comando no CMD: node index.js

URL da saída da API Javascript: http://localhost:8084/search/e659db

Comando para listar os blocos gerados: sawtooth block list --url http://rest-api:8008

Comando para visualizar um bloco específico: sawtooth block show --url http://rest-api:8008 {block} 


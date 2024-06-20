> O Docker possui alguns comandos básicos para ajudar no dia-a-dia do desenvolvedor, abaixo, citarei algumas das mais essenciais.

### Informações 📄

------------



Para consultar *infomações*, podemos utilizar comandos como `docker version` e `docker info`. No docker version, podeos obter diversas informações a respeito da nossa Engine instalada e também sobre a nossa versão do desktop. Enquanto isso, o docker info, se trata de um comando bem mais completo com diversas informações complementares sobre máquinas, servidores, sistemas operacionais e mais.

### Criando arquivos 📁
------------
No docker, temos as famosas *imagens*, sendo as responsáveis por todo o funcionamento dessa ferramenta incrível. 

####Docker File 🐋
------------
Docker File são os arquivos responsáveis por toda a configuração do nosso ambiente, que servirá como base para que futuramente vire um container, para gerar nossos arquivos dockerfile, podemos usar `docker build -t getting-started`, para gerar um arquivo básico para nós;

Agora temos diversos comandos que podem ser combinados ou utilizados no lugar de `docker build`, entre eles temos:

- `docker pull <imagem>`, para baixarmos imagens prontas da internet.
- `docker images`, para visualizar as imagens baixadas.
- `docker run -dp <portaEntrada>:<portaEntrada> <imagem>`, para rodar um único container.
- `docker rmi <imagem>`, para remover uma imagem.

> As imagens geradas por um dockerfile só podem ser upadas de forma unitária, para subirmos diversos containers precisamos utilizar do dockercompose, que vai fazer esse trabalho por nós, porém com as devidas configurações.

####Containers 🚢
------
Containers são basicamente aplicações específicas que queremos subir na nossa máquina de forma eficiente e com otimização dos recursos disponíveis, a partir dos containers, configurados pelos arquivos do tipo *dockercompose.yml*, podemos definir serviços e configura-los conforme as nossas necessidades.  Alguns dos comandos básicos são: 

-  Para listar containers, podemos usar: `docker container list | docker container list -all`
- Para listar containers ativos e parados, podemos usar na ordem: `docker ps | docker ps -a`
- Para remover um container: `docker rm <container>`
- Para subirmos um container, podemos utilizar: `docker compose up`, ou o seu comando mais "atualizado", que permite atualizações enquanto o container está de pé e atualiza o mesmo automaticamente; `docker compose watch`

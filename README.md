# java-microservices
Aplicativo Java RESTful baseado em Microsserviços.

## Sobre o Aplicativo
O aplicativo RESTful que você cria é um aplicativo simples do Diretório de Funcionários.

O aplicativo tem duas partes principais.

Um back end de microsserviços (escrito em Java)
Um cliente de serviço Web (escrito em HTML, CSS e JavaScript)
As duas partes demonstram como um front-end interage com um back-end de microsserviços.

## Sobre o Serviço REST
O back-end REST é implementado em Java usando o servidor Helidon. O servidor implementa algumas operações de pesquisa com operações padrão de criação, leitura, atualização e exclusão (CRUD). A lista de pontos finais inclui:

| Ponto Final        | Método                     | Descrição                  |              
|-------------------:|----------------------------|:--------------------------:|
|/                   | GET                           |<p>Obter todos os funcionários</p> |
|/lastname/{name}   | GET                           |<p>Pesquise todos os campos lastname para o valor fornecido em "name"</p>| 
|/department/{name}| GET                           |<p>Pesquise todos os campos department para o valor informado em "name".</p>                            |
|/title/{name}      | GET                           |<p>Pesquise todos os campos title para o valor fornecido em "nome".</p>                            |
|/                   | POST                           |<p>Adicionar um novo funcionário.</p>                            |
|/{id}               | GET                           |<p>Obter um funcionário por ID.</p>                           |
|/{id}               | UPDATE                           |<p>Atualizar um funcionário por ID.</p>                            |
|/{id}               | DELETE                           |<p>delete um Funcionário com base no ID.</p>                            |


Fonte de inspiração: [Oracle](https://docs.oracle.com/pt-br/solutions/develop-microservice-java-app/index.html#GUID-AE46D8CC-8156-4C5D-869A-A488C056F359)
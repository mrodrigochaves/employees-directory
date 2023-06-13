### Implementação do Projeto de Diretório de Funcionários.
Aplicativo Java RESTful baseado em Microsserviços.

# 💻 Stacks utilizadas:
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![MySql](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

## Sobre o Aplicativo
O aplicativo RESTful que você cria é um aplicativo simples do Diretório de Funcionários.

O aplicativo tem duas partes principais.

Um back end de microsserviços (escrito em Java)
Um cliente de serviço Web (escrito em HTML, CSS e JavaScript(React)
As duas partes demonstram como um front-end interage com um back-end de microsserviços.

Aqui você pode conferir [Front-End](https://github.com/mrodrigochaves/front-employees)

## Funcionalidades
  Cadastro de Funcionários: Permite adicionar informações de novos funcionários ao diretório, incluindo nome, cargo, departamento;

  Atualização de Funcionários: Possibilita a atualização dos dados de um funcionário já cadastrado no diretório. É possível modificar informações como cargo, departamento;

  Exclusão de Funcionários: Permite a remoção de funcionários do diretório.

  Consulta de Funcionários: Permite pesquisar e visualizar informações de funcionários cadastrados no diretório. É possível filtrar a busca por nome, cargo ou departamento.

## Sobre o Serviço REST
O back-end REST é implementado em Java usando o servidor Mysql. O servidor implementa algumas operações de pesquisa com operações padrão de criação, leitura, atualização e exclusão (CRUD). A lista de pontos finais inclui:

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

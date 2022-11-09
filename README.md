#################################################
Com base no modelo de API sugerido em aula, crie:
1 - Especifique um cenário de aplicação e defina ao menos uma entidade, a ser representada por um respectivo POJO;
2 - Escreva a tabela de rotas da API para manipulação desta entidade, com os respectivos parâmetros e retornos,
	comentando o funcionamento quando necessário.
3 - Usando o Node.js, implemente esta API. A persistência dos dados pode ser em memória.

Entregue o zip com o projeto Node.js e a descrição da API.


Aplicar a autenticação por Token, de preferência JWT, na API. Exigir autenticação de todas as rotas que envolvam alteração de dados.
Para uma aplicação ainda melhor, pode-se criar dois ou mais papéis (roles) na aplicação, exigindo-se autenticação de todas as rotas e somente permitindo alterações com o papel adequado. Por exemplo, user e admin: ambos acessam todas as rotas, porém só admin pode realizar as rotas de autenticação. Cuidar para retornar os status codes adequados para as rotas não autorizadas.

Formato de entrega: github, com arquivo de documentação.

EDIT: quem já fez autenticação com JWT, deve procurar outra forma de autenticação: framework Passport; OAuth2, com Google, Facebook ou Github.

#################################################

#Projeto - Spring Restful API

- Model: possui a entidade utilizada;
- DTO: possui o objeto que será recebido nas requisições; DTO pattern;
- a classe REST controller possui o mapeamento das requisições;
- A etidade é gerenciada pela interface que utiliza os repositórios do Spring Data JPA;

Para rodar o projeto e testar:
- Configurar maven e spring;
- acessar as urls pelo postman;

Mapping:
GET - http://localhost:8080/home/ (não  precisa de autenticação)
POST - http://localhost:8080/login/ (autenticação - username e password no body)

Rotas protegidas (role única ADMIN - usuário padrão: admin password: password)
find all - GET - http://localhost:8080/estacoes/
find by id - GET -  http://localhost:8080/estacoes/{idEstacao}
save - POST (objeto deve ser enviado no body) -  http://localhost:8080/estacoes/
update - PUT -  http://localhost:8080/estacoes/{idEstacao}
delete by id - DELETE -  http://localhost:8080/estacoes/{idEstacao}



https://imasters.com.br/desenvolvimento/autenticacao-com-jwt-no-spring-boot


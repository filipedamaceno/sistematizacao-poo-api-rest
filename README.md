# API para gerenciamento de entregadores

## Instruções para colocar em operação

### Requisitos
- Java 17
- PostgreSQL
  - Database: entregadores
  - Username: postgres
  - Password: filipedb

### Instalação
- Clone este projeto
- Importe para sua IDE de escolha
- Atualize as bibliotecas com o Maven
- Inicialize

### Acesso
- Abra o um gerenciador de API, como o Postman ou Insomnia

### Utilização

Para incluir um entregador
	
	- URI: http://localhost:8080/entregadores
	
	- Método: POST
	
	- Formulário JSON: nome, cpf, carga
	
Para listar todos os filmes
	
	- URI: http://localhost:8080/entregadores
	
	- Método: GET
	
Para mostrar apenas um filme
	
	- URI: http://localhost:8080/entregadores/{id}
	
	- Método: GET
	
Para excluir um filme
	
	- URI: http://localhost:8080/entregadores/{id}
	
	- Método: DELETE

Para alterar um filme
	
	- URI: http://localhost:8080/entregadores/{id}
	
	- Método: PUT
	
	- Formulário JSON: nome, cpf, carga

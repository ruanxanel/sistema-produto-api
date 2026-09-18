#  Sistema de Produtos - API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de produtos de um supermercado.

O projeto tem como objetivo praticar o desenvolvimento de APIs REST utilizando uma arquitetura organizada em camadas, validação de dados, persistência no banco de dados e tratamento de exceções.

---

##  Sobre o projeto

A API permite realizar o gerenciamento dos produtos cadastrados no sistema.

Cada produto possui informações como:

- Nome
- Descrição
- Marca
- Categoria
- Preço
- Estoque
- Unidade de medida
- Peso/Quantidade
- Código de barras
- Data de validade
- Status do produto
- Data de cadastro

O projeto foi desenvolvido como parte dos meus estudos em **desenvolvimento Back-End com Java e Spring Boot**.

---

##  Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Lombok
- Maven
- Postman

---

##  Arquitetura

O projeto utiliza uma arquitetura baseada em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Controller

Responsável por receber as requisições HTTP e encaminhá-las para a camada Service.

### Service

Responsável pelas regras de negócio da aplicação.

### Repository

Responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

### Entity

Representa os dados dos produtos que serão persistidos no banco de dados.

### DTO

Utilizado para controlar os dados recebidos e enviados pela API.


---

##  Funcionalidades

### Cadastrar produto

```http
POST /products
```

Cadastra um novo produto no sistema.

O código de barras deve ser único.

### Listar produtos

```http
GET /products
```

Retorna todos os produtos cadastrados.

### Buscar produto por ID

```http
GET /products/{id}
```

Busca um produto específico através do seu ID.

Caso o produto não seja encontrado, uma exceção é lançada.

### Atualizar produto

```http
PUT /products/{id}
```

Atualiza as informações de um produto existente.

É possível alterar:

- Nome
- Descrição
- Marca
- Categoria
- Preço
- Estoque
- Unidade
- Peso/Quantidade
- Validade
- Status ativo/inativo

O ID, código de barras e data de cadastro não são alterados.

### Deletar produto

```http
DELETE /products/{id}
```

Remove um produto através do seu ID.

Caso o produto não exista, a API retorna uma exceção de produto não encontrado.

---

##  Exemplo de cadastro

### Request

```json
{
    "nome": "Arroz",
    "descricao": "Arroz branco",
    "marca": "União",
    "categoria": "ALIMENTOS",
    "preco": 10.50,
    "estoque": 10,
    "unidade": "KG",
    "pesoQtd": 10,
    "codigoBarras": "1234567891234",
    "validade": "2027-07-04"
}
```

### Response

```json
{
    "id": 1,
    "nome": "Arroz",
    "descricao": "Arroz branco",
    "marca": "União",
    "categoria": "ALIMENTOS",
    "preco": 10.50,
    "estoque": 10,
    "unidade": "KG",
    "pesoQtd": 10,
    "codigoBarras": "1234567891234",
    "validade": "2027-07-04",
    "ativo": true,
    "dataCadastro": "2026-09-18T10:30:00"
}
```

---

##  Validações

A API possui validações para garantir que os dados recebidos sejam válidos.

Alguns exemplos:

- Nome obrigatório
- Nome entre 3 e 100 caracteres
- Marca obrigatória
- Categoria obrigatória
- Preço maior que zero
- Preço com no máximo 2 casas decimais
- Estoque não pode ser negativo
- Unidade obrigatória
- Peso/quantidade maior que zero
- Código de barras obrigatório
- Código de barras com 13 dígitos
- Data de validade não pode estar no passado

---

##  Tratamento de exceções

O projeto possui exceções específicas para situações de negócio.

### Produto já cadastrado

Ocorre quando é realizada uma tentativa de cadastrar um produto utilizando um código de barras que já existe.

```text
ProdutoJaCadastradoException
```

### Produto não encontrado

Ocorre quando é realizada uma operação utilizando um ID que não existe.

```text
ProdutoNaoEncontradoException
```

---

##  Banco de dados

O projeto utiliza **PostgreSQL** para armazenar os produtos.

A comunicação com o banco é realizada através do **Spring Data JPA**.

---

##  Testes da API

As requisições podem ser testadas utilizando o **Postman**.

```text
POST    /products
GET     /products
GET     /products/{id}
PUT     /products/{id}
DELETE  /products/{id}
```

---

##  Conceitos praticados

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- Java
- Programação Orientada a Objetos
- Spring Boot
- API REST
- HTTP
- CRUD
- Spring Data JPA
- Repository
- Service
- Controller
- Entity
- DTO
- Bean Validation
- Optional
- Enum
- PostgreSQL
- Maven
- Tratamento de exceções
- Testes utilizando Postman

---

##  Objetivo

Este projeto faz parte da minha jornada de aprendizado em **desenvolvimento Back-End com Java e Spring Boot**.

O objetivo é aplicar na prática os conceitos estudados e construir projetos para meu portfólio.

---

##  Próximos passos

- [ ] Implementar GlobalExceptionHandler
- [ ] Melhorar tratamento de erros
- [ ] Documentar a API com Swagger
- [ ] Criar testes automatizados
- [ ] Adicionar paginação
- [ ] Adicionar filtros de produtos
- [ ] Implementar autenticação e autorização
- [ ] Criar Docker Compose para a aplicação e PostgreSQL

---

##  Autor

**Ruan Henrique**

Estudante de Ciência da Computação, focado em desenvolvimento Back-End com Java e Spring Boot.
# Seção 22 – Projeto Web Services com Spring Boot e JPA/Hibernate

> Projeto desenvolvido durante a **Seção 22** do curso **Java COMPLETO – Programação Orientada a Objetos + Projetos**, ministrado por **Nélio Alves**.

## 📖 Sobre o projeto

Este projeto consiste no desenvolvimento de uma **API REST** utilizando **Spring Boot**, aplicando os principais conceitos de desenvolvimento backend em Java, como:

* Arquitetura em camadas;
* Persistência de dados com JPA/Hibernate;
* Relacionamentos entre entidades;
* Operações CRUD;
* Tratamento de exceções;
* Banco de dados H2 para desenvolvimento;
* API REST seguindo boas práticas.

O objetivo é compreender como funciona uma aplicação backend moderna utilizando o ecossistema Spring.

---

# 🎯 Objetivos de aprendizagem

Ao concluir esta seção foi possível compreender:

* Estrutura básica de um projeto Spring Boot;
* Organização da aplicação em camadas;
* Criação de entidades JPA;
* Mapeamento objeto-relacional (ORM);
* Relacionamentos entre entidades;
* Criação de repositórios utilizando Spring Data JPA;
* Desenvolvimento de serviços;
* Construção de Controllers REST;
* Utilização de ResponseEntity;
* Tratamento de exceções personalizadas;
* Inicialização do banco de dados com dados de teste.

---

# 🛠 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven
* Banco de dados H2
* Postman (testes da API)
* IntelliJ IDEA / Eclipse

---

# 📂 Estrutura do projeto

```text
src
└── main
    ├── java
    │   └── com.seuprojeto
    │       ├── config
    │       ├── entities
    │       ├── repositories
    │       ├── resources
    │       ├── services
    │       ├── services.exceptions
    │       └── resources.exceptions
    │
    └── resources
        ├── application.properties
        └── import.sql
```

---

# 🏗 Arquitetura utilizada

A aplicação segue o padrão de arquitetura em camadas.

```text
Cliente
   │
HTTP
   │
Controller (Resource)
   │
Service
   │
Repository
   │
Banco de Dados
```

Cada camada possui uma responsabilidade específica:

## Resource (Controller)

Responsável por receber as requisições HTTP.

Exemplos:

* GET
* POST
* PUT
* DELETE

---

## Service

Responsável pelas regras de negócio.

Exemplos:

* Buscar usuário
* Inserir pedido
* Atualizar produto

---

## Repository

Responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

Exemplo:

```java
public interface UserRepository extends JpaRepository<User, Long> {

}
```

---

# 📚 Conteúdos estudados

## Spring Boot

* Criação do projeto
* Dependências Maven
* Spring Initializr
* Auto Configuration
* Starter Projects

---

## Maven

* Dependências
* Build
* Ciclo de vida
* pom.xml

---

## Spring Web

* API REST
* Controllers
* RequestMapping
* GetMapping
* PostMapping
* PutMapping
* DeleteMapping

---

## JPA

* Entidades
* ORM
* Persistência
* Anotações

Principais anotações:

```java
@Entity
@Id
@GeneratedValue
@Table
@Column
```

---

## Hibernate

Implementação da especificação JPA.

Responsável por:

* Persistência
* Consultas
* Mapeamento
* Gerenciamento de entidades

---

# 🗄 Modelagem do banco

Entidades desenvolvidas:

* User
* Order
* Product
* Category
* OrderItem
* Payment

Relacionamentos abordados:

### Um para Muitos (OneToMany)

```java
@OneToMany(mappedBy = "user")
```

---

### Muitos para Um (ManyToOne)

```java
@ManyToOne
@JoinColumn(name = "user_id")
```

---

### Muitos para Muitos (ManyToMany)

```java
@ManyToMany
@JoinTable(
    name="tb_product_category"
)
```

---

### Um para Um (OneToOne)

```java
@OneToOne(mappedBy = "order")
```

---

# 🔗 Endpoints desenvolvidos

## Users

| Método | Endpoint    |
| ------ | ----------- |
| GET    | /users      |
| GET    | /users/{id} |
| POST   | /users      |
| PUT    | /users/{id} |
| DELETE | /users/{id} |

---

## Orders

| Método | Endpoint     |
| ------ | ------------ |
| GET    | /orders      |
| GET    | /orders/{id} |

---

## Products

| Método | Endpoint       |
| ------ | -------------- |
| GET    | /products      |
| GET    | /products/{id} |

---

## Categories

| Método | Endpoint         |
| ------ | ---------------- |
| GET    | /categories      |
| GET    | /categories/{id} |

---

# ⚙ Banco H2

Durante o desenvolvimento foi utilizado o banco de dados em memória H2.

Console:

```
http://localhost:8080/h2-console
```

Configuração típica:

```
JDBC URL:
jdbc:h2:mem:testdb

User:
sa

Password:
(vazio)
```

---

# 📌 Conceitos importantes

## Injeção de Dependência

```java
@Autowired
private UserService service;
```

---

## ResponseEntity

Permite controlar a resposta HTTP.

```java
return ResponseEntity.ok(obj);
```

---

## Optional

Evita NullPointerException.

```java
Optional<User> obj = repository.findById(id);
```

---

## Bean

Objetos gerenciados pelo Spring Container.

---

## IoC (Inversion of Control)

O Spring é responsável por criar e gerenciar os objetos da aplicação.

---

## Dependency Injection

O framework injeta automaticamente as dependências necessárias.

---

# 🚨 Tratamento de exceções

Exceções implementadas:

* ResourceNotFoundException
* DatabaseException

Classe responsável pelo tratamento global:

```text
ResourceExceptionHandler
```

Anotação utilizada:

```java
@ControllerAdvice
```

---

# ▶ Como executar

## Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

---

## Entre na pasta

```bash
cd projeto
```

---

## Execute

```bash
mvn spring-boot:run
```

ou

```bash
./mvnw spring-boot:run
```

---

A aplicação ficará disponível em:

```
http://localhost:8080
```

---

# 🧪 Testando a API

Ferramentas recomendadas:

* Postman
* Insomnia
* Thunder Client (VS Code)

Exemplo de requisição:

```http
GET /users
```

Resposta:

```json
[
  {
    "id":1,
    "name":"Maria Brown",
    "email":"maria@gmail.com"
  }
]
```

---

# 📖 Principais conceitos aprendidos

* API REST
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* ORM
* Banco H2
* Maven
* Arquitetura em Camadas
* CRUD
* Relacionamentos entre entidades
* Injeção de Dependência
* Inversão de Controle (IoC)
* ResponseEntity
* Tratamento de Exceções
* Serialização JSON
* HTTP Status
* Persistência de Dados

---

# 📚 Referência

Curso:

**Java COMPLETO Programação Orientada a Objetos + Projetos**

Instrutor: **Nélio Alves**

Seção estudada:

**Seção 22 — Bônus: Projeto Web Services com Spring Boot e JPA/Hibernate**

---

# 👨‍💻 Autor

Projeto desenvolvido como parte dos estudos do curso **Java COMPLETO Programação Orientada a Objetos + Projetos**, com foco na construção de APIs REST utilizando **Spring Boot**, **Spring Data JPA** e **Hibernate**, visando consolidar conhecimentos em desenvolvimento backend com Java.

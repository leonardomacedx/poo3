# Projeto POO3

## Visão Geral
Este projeto é uma aplicação Spring Boot para gerenciamento de adoção de animais. Ele fornece APIs RESTful para criar, ler, atualizar e deletar registros de animais.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Banco de Dados H2
- Maven

## Começando

### Pré-requisitos
- Java 21 ou superior
- Maven
- 
### Instalação
1. Clone o repositório:
    ```sh
    git clone https://github.com/leonardomacedx/poo3.git
    cd poo3
    ```

2. Construa o projeto:
    ```sh
    mvn clean install
    ```

3. Execute a aplicação:
    ```sh
    mvn spring-boot:run
    ```
   
4. Acesse a aplicação em `http://localhost:8080`

**Caso use alguma IDE, você pode importar o projeto como um projeto Maven e rodar a aplicação a partir da IDE.**

### Configuração
A aplicação utiliza um banco de dados H2 em memória. Você pode acessar o console H2 em `/h2-console` com as seguintes credenciais:
- **JDBC URL:** `jdbc:h2:mem:db`
- **Usuário:** `sa`
- **Senha:** (deixe em branco)

### Documentação da API
A documentação da API está disponível em `/documentacao` quando a aplicação estiver em execução. 
É possível testar os endpoints diretamente na documentação.

## Uso

### Endpoints

#### Criar um Animal
- **URL:** `/cadastro`
- **Método:** `POST`
- **Corpo da Requisição:**
    ```json
    {
        "nome": "string",
        "tipo": "string",
        "idade": "integer",
        "raca": "string",
        "descricao": "string"
    }
    ```

#### Obter Todos os Animais
- **URL:** `/animais`
- **Método:** `GET`

#### Obter Animal por ID
- **URL:** `/animais/{id}`
- **Método:** `GET`

#### Atualizar Animal por ID
- **URL:** `/animais/{id}`
- **Método:** `PUT`
- **Corpo da Requisição:**
    ```json
    {
        "nome": "string",
        "tipo": "string",
        "idade": "integer",
        "raca": "string",
        "status": "string",
        "descricao": "string"
    }
    ```
  -- Nenhum campo é obrigatório

#### Deletar Animal por ID
- **URL:** `/animais/{id}`
- **Método:** `DELETE`

## Tratamento de Exceções
Exceções personalizadas são tratadas pelo `GlobalExceptionHandler` para fornecer mensagens de erro significativas.
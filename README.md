# Global Solution - Primeiro semestre

<p>API RESTful para gerenciamento de usuários e eventos de queda de energia.</p>
Integrantes:
<li>Felipe Hideki Iwasa RM98323</li>
<li>Guilherme Milheiro RM550295</li>
<li>Enzo Vasconcelos RM550702</li>

## Sumário

- [Usuários](#usuários)
  - [Criar Usuário](#criar-usuário)
  - [Atualizar Usuário](#atualizar-usuário)
  - [Listar Usuários](#listar-usuários)
  - [Buscar Usuário por ID](#buscar-usuário-por-id)
  - [Deletar Usuário](#deletar-usuário)
- [Eventos](#eventos)
  - [Criar Evento](#criar-evento)
  - [Atualizar Evento](#atualizar-evento)
  - [Listar Eventos](#listar-eventos)
  - [Buscar Evento por ID](#buscar-evento-por-id)
  - [Buscar Eventos por Estado](#buscar-eventos-por-estado)
  - [Buscar Eventos por Região e Estado](#buscar-eventos-por-região-e-estado)
  - [Deletar Evento](#deletar-evento)
- [Tabelas](#tabelas)

---

## Usuários

### Criar Usuário

- **POST** `/usuarios`
- **Request Body:**
  ```json
  {
    "nome": "string",
    "username": "string",
    "senha": "string"
  }
  ```
- **Response:** 201 Created  
  ```json
  {
    "id": 1,
    "nome": "string",
    "username": "string"
  }
  ```

---

### Atualizar Usuário

- **PUT** `/usuarios/{id}`
- **Request Body:**
  ```json
  {
    "nome": "string",
    "username": "string",
    "senha": "string"
  }
  ```
- **Response:** 200 OK  
  ```json
  {
    "id": 1,
    "nome": "string",
    "username": "string"
  }
  ```
- **404 Not Found** se o usuário não existir.

---

### Listar Usuários

- **GET** `/usuarios`
- **Response:** 200 OK  
  ```json
  [
    {
      "id": 1,
      "nome": "string",
      "username": "string"
    }
  ]
  ```

---

### Buscar Usuário por ID

- **GET** `/usuarios/{id}`
- **Response:** 200 OK  
  ```json
  {
    "id": 1,
    "nome": "string",
    "username": "string"
  }
  ```
- **404 Not Found** se o usuário não existir.

---

### Deletar Usuário

- **DELETE** `/usuarios/{id}`
- **Response:** 204 No Content  
- **404 Not Found** se o usuário não existir.

---

## Eventos

### Criar Evento

- **POST** `/eventos`
- **Request Body:**
  ```json
  {
  	"idUsuario": 1,
  	"endereco": {
  		"logradouro": "Rua Edward Joseph",
  		"numero": 33,
  		"complemento": "bloco 23, ap 22",
  		"bairro": "Portal do Morumbi",
  		"cidade": "São Paulo"
  	},
  	"cep": "03485-091",
  	"regiao": "Zona Sul",
  	"estado": "SP",
  	"causa": "Chuva intensa",
  	"descricao": "Queda de luz após chuva intensa"
  }
  ```
- **Response:** 201 Created  
  ```json
  {
  	"nomeUsuario": "hidekieeeee",
  	"endereco": "Rua Edward Joseph 33, bloco 23, ap 22, Portal do Morumbi São Paulo",
  	"cep": "03485-091",
  	"regiao": "Zona Sul",
  	"estado": "SP",
  	"causa": "Chuva intensa",
  	"descricao": "Queda de luz após chuva intensa",
  	"status": "OCORRENDO",
  	"quandoComecou": "2025-06-06T07:39:43.9041678"
  }
  ```
- **400 Bad Request** se o usuário não existir.

---

### Atualizar Evento

- **PUT** `/eventos/{id}`
- **Request Body:**
  ```json
  {
  	"endereco": {
  		"logradouro": "Rua Jaracatia",
  		"numero": 257,
  		"complemento": "bloco 30, ap 12",
  		"bairro": "Jardim Umarizal",
  		"cidade": "São Paulo"
  	},
  	"cep": "03493-091",
  	"regiao": "Zona Sul",
  	"estado": "SP",
  	"causa": "Queda de poste",
  	"descricao": "Queda de luz devido um poste quebrado",
  	"status": "OCORRENDO"
  }
  ```
- **Response:** 200 OK  
  ```json
  {
  	"nomeUsuario": "hidekieeeee",
  	"endereco": "Rua Jaracatia 257 bloco 30, ap 12 Jardim Umarizal São Paulo",
  	"cep": "03493-091",
  	"regiao": "Zona Sul",
  	"estado": "SP",
  	"causa": "Queda de poste",
  	"descricao": "Queda de luz devido um poste quebrado",
  	"status": "OCORRENDO",
  	"quandoComecou": "2025-05-30T00:00:00"
  }
  ```
- **404 Not Found** se o evento não existir.

---

### Listar Eventos

- **GET** `/eventos`
- **Response:** 200 OK  
  ```json
  [
  	{
  		"nomeUsuario": "hidekieeeee",
  		"endereco": "Rua Jaracatia 257 bloco 30, ap 12 Jardim Umarizal São Paulo",
  		"cep": "03493-091",
  		"regiao": "Zona Sul",
  		"estado": "SP",
  		"causa": "Queda de poste",
  		"descricao": "Queda de luz devido um poste quebrado",
  		"status": "OCORRENDO",
  		"quandoComecou": "2025-05-30T00:00:00",
  		"duracao": "7 dias, 7 horas, 47 minutos"
  	},
  	{
  		"nomeUsuario": "hidekieeeee",
  		"endereco": "Rua Edward Joseph 33, bloco 23, ap 22, Portal do Morumbi São Paulo",
  		"cep": "03485-091",
  		"regiao": "Zona Sul",
  		"estado": "SP",
  		"causa": "Chuva intensa",
  		"descricao": "Queda de luz após chuva intensa",
  		"status": "OCORRENDO",
  		"quandoComecou": "2025-06-06T07:39:44",
  		"duracao": "7 minutos"
  	}
  ]
  ```

---

### Buscar Evento por ID

- **GET** `/eventos/{id}`
- **Response:** 200 OK  
  ```json
  {
  	"nomeUsuario": "hidekieeeee",
  	"endereco": "Rua Jaracatia 257 bloco 30, ap 12 Jardim Umarizal São Paulo",
  	"cep": "03493-091",
  	"regiao": "Zona Sul",
  	"estado": "SP",
  	"causa": "Queda de poste",
  	"descricao": "Queda de luz devido um poste quebrado",
  	"status": "OCORRENDO",
  	"quandoComecou": "2025-05-30T00:00:00",
  	"duracao": "7 dias, 15 horas, 44 minutos"
  }
  ```
- **404 Not Found** se o evento não existir.

---

### Buscar Eventos por Estado

- **GET** `/eventos/estado?estado=AL`
- **Response:** 200 OK  
  ```json
  [
  	{
  		"nomeUsuario": "hidekieeeee",
  		"endereco": "Rua Alemanha 33 Bloco B, Apartamento 302 – Edifício Residencial Clima Verde Clima Bom Maceió",
  		"cep": "03485-091",
  		"regiao": "Zona Oeste",
  		"estado": "AL",
  		"causa": "Manutenção",
  		"descricao": "Queda de luz por conta da manutenção de tarde",
  		"status": "OCORRENDO",
  		"quandoComecou": "2025-06-06T15:47:31",
  		"duracao": ""
  	}
  ]
  ```

---

### Buscar Eventos por Região e Estado

- **GET** `/eventos/regiaoestado?estado=SP&regiao=Sul`
- **Response:** 200 OK  
  ```json
  [
  	{
  		"nomeUsuario": "hidekieeeee",
  		"endereco": "Rua Jaracatia 257 bloco 30, ap 12 Jardim Umarizal São Paulo",
  		"cep": "03493-091",
  		"regiao": "Zona Sul",
  		"estado": "SP",
  		"causa": "Queda de poste",
  		"descricao": "Queda de luz devido um poste quebrado",
  		"status": "OCORRENDO",
  		"quandoComecou": "2025-05-30T00:00:00",
  		"duracao": "7 dias, 7 horas, 47 minutos"
  	},
  	{
  		"nomeUsuario": "hidekieeeee",
  		"endereco": "Rua Edward Joseph 33, bloco 23, ap 22, Portal do Morumbi São Paulo",
  		"cep": "03485-091",
  		"regiao": "Zona Sul",
  		"estado": "SP",
  		"causa": "Chuva intensa",
  		"descricao": "Queda de luz após chuva intensa",
  		"status": "OCORRENDO",
  		"quandoComecou": "2025-06-06T07:39:44",
  		"duracao": "7 minutos"
  	}
  ]
  ```

---

### Deletar Evento

- **DELETE** `/eventos/{id}`
- **Response:** 204 No Content  
- **404 Not Found** se o evento não existir.

---

# Tabelas

### Usuário

```sql
CREATE TABLE usuario(
	  id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    username varchar(30) NOT NULL UNIQUE,
    senha varchar(30) NOT NULL
);
```

## Evento

```sql
CREATE TABLE evento(
	  id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_usuario bigint NOT NULL,
    endereco varchar(100) NOT NULL,
    cep varchar(9) NOT NULL,
	  regiao varchar(20) NOT NULL,
    estado varchar(2) NOT NULL,
    causa varchar(50) NOT NULL,
    descricao varchar(300),
    status ENUM('OCORRENDO', 'ENCERRADO') NOT NULL,
    quando_comecou DATETIME NOT NULL,
    FOREIGN KEY (id_usuario) references usuario(id)
);
```

---

O banco utlizado é MySQL


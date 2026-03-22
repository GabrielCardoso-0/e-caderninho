# 📘 Documentação da API — E-Caderninho

Base URL: `http://localhost:8080`

---

## 👤 Usuários — `/usuarios`

### `POST /usuarios`
Cria um novo usuário.

**Request body:**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "estabelecimento": "Loja do João",
  "senha": "123456"
}
```

**Response `200`:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "estabelecimento": "Loja do João"
}
```

---

### `GET /usuarios`
Retorna todos os usuários.

**Response `200`:**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com",
    "estabelecimento": "Loja do João"
  }
]
```

---

### `GET /usuarios/{id}`
Retorna um usuário pelo ID.

**Parâmetro de path:** `id` (Long)

**Response `200`:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "estabelecimento": "Loja do João"
}
```

---

### `GET /usuarios/email/{email}`
Retorna um usuário pelo e-mail.

**Parâmetro de path:** `email` (String)

**Response `200`:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "estabelecimento": "Loja do João"
}
```

---

### `PUT /usuarios/{id}`
Atualiza os dados de um usuário.

**Parâmetro de path:** `id` (Long)

**Request body:**
```json
{
  "nome": "João Atualizado",
  "email": "joao_novo@email.com",
  "estabelecimento": "Nova Loja",
  "senha": "novaSenha"
}
```

**Response `200`:**
```json
{
  "id": 1,
  "nome": "João Atualizado",
  "email": "joao_novo@email.com",
  "estabelecimento": "Nova Loja"
}
```

---

### `DELETE /usuarios/{id}`
Remove um usuário pelo ID.

**Parâmetro de path:** `id` (Long)

**Response `200`:** sem corpo

---

## 💳 Formas de Pagamento — `/formas-pagamento`

### `POST /formas-pagamento`
Cria uma nova forma de pagamento.

**Request body:**
```json
{
  "descricao": "Cartão de Crédito",
  "ativo": true
}
```

**Response `200`:**
```json
{
  "id": 1,
  "descricao": "Cartão de Crédito",
  "ativo": true
}
```

---

### `GET /formas-pagamento`
Retorna todas as formas de pagamento.

**Response `200`:**
```json
[
  {
    "id": 1,
    "descricao": "Cartão de Crédito",
    "ativo": true
  }
]
```

---

### `GET /formas-pagamento/ativas`
Retorna apenas as formas de pagamento ativas.

**Response `200`:**
```json
[
  {
    "id": 1,
    "descricao": "Cartão de Crédito",
    "ativo": true
  }
]
```

---

### `GET /formas-pagamento/{id}`
Retorna uma forma de pagamento pelo ID.

**Parâmetro de path:** `id` (Long)

**Response `200`:**
```json
{
  "id": 1,
  "descricao": "Cartão de Crédito",
  "ativo": true
}
```

---

### `PUT /formas-pagamento/{id}`
Atualiza uma forma de pagamento.

**Parâmetro de path:** `id` (Long)

**Request body:**
```json
{
  "descricao": "Cartão de Débito",
  "ativo": false
}
```

**Response `200`:**
```json
{
  "id": 1,
  "descricao": "Cartão de Débito",
  "ativo": false
}
```

---

### `DELETE /formas-pagamento/{id}`
Remove uma forma de pagamento pelo ID.

**Parâmetro de path:** `id` (Long)

**Response `200`:** sem corpo

---

## 👥 Clientes — `/clientes`

### `POST /clientes`
Cria um novo cliente vinculado a um usuário.

**Request body:**
```json
{
  "idUsuario": 1,
  "nome": "Maria Souza",
  "cpf": "123.456.789-00"
}
```

**Response `200`:**
```json
{
  "id": 1,
  "idUsuario": 1,
  "nomeUsuario": "João Silva",
  "nome": "Maria Souza",
  "cpf": "123.456.789-00"
}
```

---

### `GET /clientes`
Retorna todos os clientes.

**Response `200`:**
```json
[
  {
    "id": 1,
    "idUsuario": 1,
    "nomeUsuario": "João Silva",
    "nome": "Maria Souza",
    "cpf": "123.456.789-00"
  }
]
```

---

### `GET /clientes/usuario/{idUsuario}`
Retorna todos os clientes de um usuário específico.

**Parâmetro de path:** `idUsuario` (Long)

**Response `200`:**
```json
[
  {
    "id": 1,
    "idUsuario": 1,
    "nomeUsuario": "João Silva",
    "nome": "Maria Souza",
    "cpf": "123.456.789-00"
  }
]
```

---

### `GET /clientes/{id}`
Retorna um cliente pelo ID.

**Parâmetro de path:** `id` (Long)

**Response `200`:**
```json
{
  "id": 1,
  "idUsuario": 1,
  "nomeUsuario": "João Silva",
  "nome": "Maria Souza",
  "cpf": "123.456.789-00"
}
```

---

### `PUT /clientes/{id}`
Atualiza os dados de um cliente.

**Parâmetro de path:** `id` (Long)

**Request body:**
```json
{
  "idUsuario": 1,
  "nome": "Maria Atualizada",
  "cpf": "987.654.321-00"
}
```

**Response `200`:**
```json
{
  "id": 1,
  "idUsuario": 1,
  "nomeUsuario": "João Silva",
  "nome": "Maria Atualizada",
  "cpf": "987.654.321-00"
}
```

---

### `DELETE /clientes/{id}`
Remove um cliente pelo ID.

**Parâmetro de path:** `id` (Long)

**Response `200`:** sem corpo

---

## 🛒 Vendas — `/vendas`

> ⚠️ O campo `idCliente` é opcional — uma venda pode ser registrada sem cliente vinculado.

### `POST /vendas`
Registra uma nova venda.

**Request body:**
```json
{
  "idUsuario": 1,
  "idCliente": 1,
  "idFormaPagamento": 1,
  "valor": 150.00,
  "observacao": "Venda à vista",
  "pago": true
}
```

**Response `200`:**
```json
{
  "id": 1,
  "idUsuario": 1,
  "nomeUsuario": "João Silva",
  "idCliente": 1,
  "nomeCliente": "Maria Souza",
  "idFormaPagamento": 1,
  "descricaoFormaPagamento": "Cartão de Crédito",
  "valor": 150.00,
  "observacao": "Venda à vista",
  "data": "2026-03-22T20:00:00",
  "pago": true
}
```

---

### `GET /vendas`
Retorna todas as vendas.

**Response `200`:** lista de vendas (mesmo formato do response acima)

---

### `GET /vendas/usuario/{idUsuario}`
Retorna todas as vendas de um usuário.

**Parâmetro de path:** `idUsuario` (Long)

**Response `200`:** lista de vendas

---

### `GET /vendas/cliente/{idCliente}`
Retorna todas as vendas de um cliente.

**Parâmetro de path:** `idCliente` (Long)

**Response `200`:** lista de vendas

---

### `GET /vendas/usuario/{idUsuario}/pago/{pago}`
Retorna vendas de um usuário filtradas por status de pagamento.

**Parâmetros de path:**
- `idUsuario` (Long)
- `pago` (Boolean: `true` ou `false`)

**Exemplo:** `GET /vendas/usuario/1/pago/false` → vendas pendentes do usuário 1

**Response `200`:** lista de vendas

---

### `GET /vendas/{id}`
Retorna uma venda pelo ID.

**Parâmetro de path:** `id` (Long)

**Response `200`:** objeto de venda

---

### `PUT /vendas/{id}`
Atualiza uma venda existente.

**Parâmetro de path:** `id` (Long)

**Request body:**
```json
{
  "idUsuario": 1,
  "idCliente": 1,
  "idFormaPagamento": 2,
  "valor": 200.00,
  "observacao": "Atualizado",
  "pago": true
}
```

**Response `200`:** objeto de venda atualizado

---

### `DELETE /vendas/{id}`
Remove uma venda pelo ID.

**Parâmetro de path:** `id` (Long)

**Response `200`:** sem corpo

---

## 📌 Observações gerais

- A senha do usuário **nunca é retornada** nas respostas
- O campo `data` da venda é preenchido **automaticamente** pelo servidor se não informado
- Todos os erros retornam `RuntimeException` com mensagem descritiva (ex: `"Usuário não encontrado"`)
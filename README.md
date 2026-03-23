# 📒 E-Caderninho

> **Seu caderno de fiado no digital.** Controle de vendas, clientes e pagamentos direto do celular — simples, rápido e offline.

[![Versão](https://img.shields.io/badge/versão-1.0.0-7c3aed?style=flat-square)](https://github.com/GabrielCardoso-0/e-caderninho)
[![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6db33f?style=flat-square&logo=spring)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479a1?style=flat-square&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Licença](https://img.shields.io/badge/licença-MIT-22c55e?style=flat-square)](LICENSE)

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Banco de Dados](#-banco-de-dados)
- [Instalação e Configuração](#-instalação-e-configuração)
- [Variáveis de Ambiente](#-variáveis-de-ambiente)
- [Executando a API](#-executando-a-api)
- [Endpoints da API](#-endpoints-da-api)
- [Frontend](#-frontend)
- [Deploy](#-deploy)
- [Planos e Preços](#-planos-e-preços)
- [Roadmap](#-roadmap)
- [Contribuindo](#-contribuindo)
- [Autor](#-autor)

---

## 💡 Sobre o Projeto

O **E-Caderninho** nasceu para substituir o caderno físico de fiado usado por pequenos comerciantes — padarias, mercadinhos, bares, barbearias e lanchonetes.

O sistema permite registrar vendas em segundos, controlar clientes e pagamentos, visualizar quem está devendo e exportar resumos direto para o WhatsApp. Tudo no celular, sem precisar instalar nada, com suporte a modo offline.

**Problema resolvido:** comerciantes que perdem dinheiro por esquecer quem deve, ter cadernos rasgados ou ilegíveis e não ter visão clara do financeiro do negócio.

---

## ✨ Funcionalidades

### 🛒 Vendas
- Registrar venda em menos de 5 segundos
- Vincular cliente opcional
- Selecionar forma de pagamento
- Toggle "Já foi pago?" com detecção automática de "Venda a prazo"
- Campo de recebido com cálculo automático de troco
- Observação livre
- Histórico de vendas do dia com resumo
- Registro offline com sincronização automática

### 👥 Clientes
- Cadastro com nome, CPF e celular
- Busca em tempo real por nome, CPF ou contato
- Paginação com ordenação A→Z / Z→A
- Visualização detalhada com campos copiáveis
- Edição inline no mesmo modal
- Histórico completo de compras por cliente
- Máscara automática de CPF e telefone

### 💰 Financeiro
- Resumo com total recebido, a receber, vendas pagas e pendentes
- Barra de progresso recebido vs pendente
- Gráfico de barras dos últimos 7 dias
- Resumo discreto por forma de pagamento
- Lista de devedores com valor total por cliente
- Registrar pagamento parcial ou total
- Lista de clientes que já pagaram
- Busca de cliente no financeiro
- Exportar resumo do dia formatado para WhatsApp

### 🔧 Sistema
- Login com e-mail e senha
- Modo claro e escuro (salvo no localStorage)
- PWA instalável na tela inicial do celular
- Modo offline — vendas salvas localmente e sincronizadas ao voltar online
- Badge de status offline/sincronização no header
- Botão de suporte direto para WhatsApp
- Copyright e link para GitHub no rodapé do login

---

## 🛠 Tecnologias

### Backend
| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 21 | Linguagem principal |
| Spring Boot | 3.x | Framework web |
| Spring Data JPA | 3.x | Persistência de dados |
| Hibernate | 6.x | ORM |
| MySQL | 8.0 | Banco de dados produção |
| Maven | 3.9 | Gerenciamento de dependências |

### Frontend
| Tecnologia | Uso |
|---|---|
| HTML5 | Estrutura |
| CSS3 | Estilização (variáveis, grid, flex, animações) |
| JavaScript puro | Lógica, fetch API, DOM |
| Plus Jakarta Sans | Tipografia (Google Fonts) |
| Service Worker | Suporte offline (PWA) |
| Web App Manifest | Instalação como app |

### Infraestrutura
| Serviço | Uso |
|---|---|
| Railway | Banco de dados MySQL na nuvem |
| Render | Deploy da API (Docker) |
| Vercel | Deploy do frontend / landing page |
| GitHub | Controle de versão |

---

## 📁 Estrutura do Projeto

```
e-caderninho/
├── src/
│   └── main/
│       ├── java/com/example/ecaderninho/
│       │   ├── CorsConfig.java                  # Configuração de CORS
│       │   ├── ECaderninhoApplication.java       # Classe principal
│       │   ├── cliente/
│       │   │   ├── Cliente.java                 # Entidade
│       │   │   ├── ClienteController.java        # Endpoints REST
│       │   │   ├── ClienteRepository.java        # Repositório JPA
│       │   │   ├── ClienteRequest.java           # DTO de entrada
│       │   │   ├── ClienteResponse.java          # DTO de saída
│       │   │   └── ClienteService.java           # Regras de negócio
│       │   ├── formapagamento/
│       │   │   ├── FormaPagamento.java
│       │   │   ├── FormaPagamentoController.java
│       │   │   ├── FormaPagamentoRepository.java
│       │   │   ├── FormaPagamentoRequest.java
│       │   │   ├── FormaPagamentoResponse.java
│       │   │   └── FormaPagamentoService.java
│       │   ├── usuario/
│       │   │   ├── Usuario.java
│       │   │   ├── UsuarioController.java
│       │   │   ├── UsuarioRepository.java
│       │   │   ├── UsuarioRequest.java
│       │   │   ├── UsuarioResponse.java
│       │   │   └── UsuarioService.java
│       │   └── venda/
│       │       ├── Venda.java
│       │       ├── VendaController.java
│       │       ├── VendaRepository.java
│       │       ├── VendaRequest.java
│       │       ├── VendaResponse.java
│       │       └── VendaService.java
│       └── resources/
│           └── application.properties
├── frontend/
│   ├── app.html                                 # App principal (usuário final)
│   ├── index.html                               # Painel administrativo
│   ├── landing.html                             # Landing page / site de vendas
│   ├── manifest.json                            # PWA manifest
│   └── sw.js                                    # Service Worker (offline)
├── Dockerfile                                   # Imagem Docker para deploy
├── pom.xml                                      # Dependências Maven
└── README.md
```

---

## 🗃 Banco de Dados

### Diagrama das tabelas

```
┌─────────────┐       ┌─────────────┐       ┌──────────────────┐
│  usuarios   │       │  clientes   │       │ formas_pagamento  │
├─────────────┤       ├─────────────┤       ├──────────────────┤
│ id (PK)     │──┐    │ id (PK)     │       │ id (PK)          │
│ nome        │  └───►│ id_usuario  │       │ descricao        │
│ email       │       │ nome        │       │ ativo            │
│ estab.      │       │ cpf         │       └────────┬─────────┘
│ senha       │       │ contato     │                │
└─────────────┘       └──────┬──────┘                │
                             │                       │
                    ┌────────▼───────────────────────▼──┐
                    │              vendas                │
                    ├────────────────────────────────────┤
                    │ id (PK)                            │
                    │ id_usuario (FK → usuarios)         │
                    │ id_cliente (FK → clientes)         │
                    │ id_forma_pgto (FK → formas_pgto)   │
                    │ valor                              │
                    │ observacao                         │
                    │ data                               │
                    │ pago                               │
                    └────────────────────────────────────┘
```

### Scripts SQL

```sql
CREATE TABLE usuarios (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome          VARCHAR(100) NOT NULL,
  email         VARCHAR(100) UNIQUE,
  estabelecimento VARCHAR(100),
  senha         VARCHAR(255)
);

CREATE TABLE clientes (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_usuario    BIGINT NOT NULL,
  nome          VARCHAR(100),
  cpf           VARCHAR(14),
  contato       VARCHAR(20),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE formas_pagamento (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  descricao     VARCHAR(100),
  ativo         BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE vendas (
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  id_usuario    BIGINT NOT NULL,
  id_cliente    BIGINT,
  id_forma_pgto BIGINT NOT NULL,
  valor         DECIMAL(10,2) NOT NULL,
  observacao    VARCHAR(255),
  data          DATETIME DEFAULT CURRENT_TIMESTAMP,
  pago          BOOLEAN,
  FOREIGN KEY (id_usuario)    REFERENCES usuarios(id),
  FOREIGN KEY (id_cliente)    REFERENCES clientes(id),
  FOREIGN KEY (id_forma_pgto) REFERENCES formas_pagamento(id)
);
```

---

## ⚙️ Instalação e Configuração

### Pré-requisitos

- [Java 21+](https://openjdk.org/)
- [Maven 3.9+](https://maven.apache.org/)
- [MySQL 8.0+](https://www.mysql.com/) ou conta no [Railway](https://railway.app/)
- [Docker](https://www.docker.com/) *(opcional, para deploy)*

### Clonando o repositório

```bash
git clone https://github.com/GabrielCardoso-0/e-caderninho.git
cd e-caderninho
```

### Configurando o banco local

```bash
# Crie o banco de dados no MySQL
mysql -u root -p
CREATE DATABASE caderninho_db;
EXIT;
```

---

## 🔐 Variáveis de Ambiente

### `application.properties` — desenvolvimento local

```properties
# Banco local
spring.datasource.url=jdbc:mysql://localhost:3306/caderninho_db
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Servidor
server.port=8080
```

### Variáveis para produção (Render)

Configure no painel **Environment** do Render:

| Variável | Descrição | Exemplo |
|---|---|---|
| `DB_URL` | URL JDBC do banco | `jdbc:mysql://host:porta/db?useSSL=true` |
| `DB_USER` | Usuário do banco | `root` |
| `DB_PASSWORD` | Senha do banco | `senha_segura` |

```properties
# application.properties — produção
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
```

---

## ▶️ Executando a API

### Modo desenvolvimento

```bash
# Com Maven Wrapper
./mvnw spring-boot:run

# Com perfil local explícito
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

### Gerando o JAR

```bash
./mvnw clean package -DskipTests
java -jar target/*.jar
```

### Com Docker

```bash
# Build da imagem
docker build -t e-caderninho .

# Executar o container
docker run -p 8080:8080 \
  -e DB_URL=jdbc:mysql://host:porta/db \
  -e DB_USER=root \
  -e DB_PASSWORD=senha \
  e-caderninho
```

### Dockerfile

```dockerfile
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 📡 Endpoints da API

**Base URL:** `http://localhost:8080`

### 👤 Usuários — `/usuarios`

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/usuarios` | Criar usuário |
| `GET` | `/usuarios` | Listar todos |
| `GET` | `/usuarios/{id}` | Buscar por ID |
| `GET` | `/usuarios/email/{email}` | Buscar por e-mail |
| `PUT` | `/usuarios/{id}` | Atualizar |
| `DELETE` | `/usuarios/{id}` | Deletar |

**Exemplo — criar usuário:**
```json
POST /usuarios
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "estabelecimento": "Mercadinho do João",
  "senha": "123456"
}
```

**Resposta:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "estabelecimento": "Mercadinho do João"
}
```
> ⚠️ A senha **nunca** é retornada nas respostas.

---

### 👥 Clientes — `/clientes`

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/clientes` | Criar cliente |
| `GET` | `/clientes` | Listar todos |
| `GET` | `/clientes/{id}` | Buscar por ID |
| `GET` | `/clientes/usuario/{idUsuario}` | Listar por usuário |
| `GET` | `/clientes/contato/{contato}` | Buscar por contato |
| `GET` | `/clientes/usuario/{id}/contato?q=` | Buscar por contato do usuário |
| `PUT` | `/clientes/{id}` | Atualizar |
| `DELETE` | `/clientes/{id}` | Deletar |

**Exemplo — criar cliente:**
```json
POST /clientes
{
  "idUsuario": 1,
  "nome": "Maria Souza",
  "cpf": "123.456.789-00",
  "contato": "(51) 99999-1234"
}
```

---

### 💳 Formas de Pagamento — `/formas-pagamento`

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/formas-pagamento` | Criar |
| `GET` | `/formas-pagamento` | Listar todas |
| `GET` | `/formas-pagamento/ativas` | Listar só ativas |
| `GET` | `/formas-pagamento/{id}` | Buscar por ID |
| `PUT` | `/formas-pagamento/{id}` | Atualizar |
| `DELETE` | `/formas-pagamento/{id}` | Deletar |

---

### 🛒 Vendas — `/vendas`

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/vendas` | Registrar venda |
| `GET` | `/vendas` | Listar todas |
| `GET` | `/vendas/{id}` | Buscar por ID |
| `GET` | `/vendas/usuario/{idUsuario}` | Listar por usuário |
| `GET` | `/vendas/cliente/{idCliente}` | Listar por cliente |
| `GET` | `/vendas/usuario/{id}/pago/{pago}` | Filtrar por status |
| `PUT` | `/vendas/{id}` | Atualizar |
| `DELETE` | `/vendas/{id}` | Deletar |

**Exemplo — registrar venda:**
```json
POST /vendas
{
  "idUsuario": 1,
  "idCliente": 2,
  "idFormaPagamento": 1,
  "valor": 35.50,
  "observacao": "Compra do dia",
  "pago": true
}
```

> O campo `idCliente` é **opcional** — venda pode ser registrada sem cliente vinculado.
> O campo `data` é preenchido **automaticamente** pelo servidor.

---

### 🔒 CORS

O CORS está configurado para aceitar qualquer origem em desenvolvimento. Para produção, altere em `CorsConfig.java`:

```java
@Override
public void addCorsMappings(CorsRegistry registry) {
  registry.addMapping("/**")
    .allowedOrigins("https://seu-frontend.vercel.app")
    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
    .allowedHeaders("*");
}
```

---

## 🖥 Frontend

O projeto possui **três interfaces** distintas:

### `app.html` — Aplicativo do usuário final
Interface mobile-first para o comerciante usar no dia a dia.

**Funcionalidades:**
- Login com e-mail e senha
- Registro de vendas com busca de cliente
- Gestão de clientes com paginação
- Financeiro com gráficos e devedores
- Modo offline com sincronização
- PWA instalável
- Modo claro/escuro
- Suporte via WhatsApp

**Como usar:**
1. Coloque `app.html`, `sw.js` e `manifest.json` no mesmo diretório
2. Sirva via servidor HTTP (não funciona com `file://`)
3. Altere a constante `BASE` no JavaScript para a URL da sua API:
```javascript
const BASE = 'https://sua-api.onrender.com';
```

---

### `index.html` — Painel administrativo
Interface desktop para gerenciamento completo do sistema.

**Funcionalidades:**
- CRUD completo de usuários, clientes, formas de pagamento e vendas
- Paginação em todas as listas
- Filtros avançados
- Gráficos e métricas

---

### `landing.html` — Site de vendas
Landing page para conversão de novos usuários.

**Seções:**
- Hero com mockup interativo animado
- Problema / Solução
- Funcionalidades
- Demo visual com 3 telas simuladas
- Benefícios
- Depoimentos
- Planos e preços
- FAQ
- CTA final

**Deploy na Vercel:**
1. Renomeie para `index.html`
2. Coloque na raiz do repositório
3. Configure na Vercel: Framework = `Other`, Output Directory = `.`

---

## 🚀 Deploy

### Backend no Render (Docker)

1. Crie um novo **Web Service** no [Render](https://render.com)
2. Conecte o repositório GitHub
3. Configure:
   - **Environment:** Docker
   - **Dockerfile Path:** `./Dockerfile`
4. Adicione as variáveis de ambiente (`DB_URL`, `DB_USER`, `DB_PASSWORD`)
5. Clique em **Deploy**

### Banco no Railway

1. Acesse [Railway](https://railway.app)
2. **New Project → Deploy MySQL**
3. Copie as variáveis `MYSQL_PUBLIC_URL`, `MYSQLUSER`, `MYSQLPASSWORD`
4. Use a **Public URL** no Render (não a interna)

> ⚠️ A URL do Railway começa com `mysql://` — substitua por `jdbc:mysql://` no `DB_URL`.

### Frontend na Vercel

1. Acesse [Vercel](https://vercel.com)
2. **New Project → Import** do GitHub
3. Configure:
   - **Framework Preset:** Other
   - **Build Command:** *(vazio)*
   - **Output Directory:** `.`
4. Deploy automático a cada push no `main`

---

## 💳 Planos e Preços

| Recurso | Básico R$ 19,90 | Gold R$ 29,90 | Premium R$ 39,90 |
|---|:---:|:---:|:---:|
| Clientes ilimitados | ✅ | ✅ | ✅ |
| Vendas ilimitadas | ✅ | ✅ | ✅ |
| Controle de fiado | ✅ | ✅ | ✅ |
| Gráfico 7 dias | ✅ | ✅ | ✅ |
| Exportar WhatsApp | ✅ | ✅ | ✅ |
| Modo offline / PWA | ✅ | ✅ | ✅ |
| Score de cliente | ❌ | ✅ | ✅ |
| Limite de crédito | ❌ | ✅ | ✅ |
| Vencimento do fiado | ❌ | ✅ | ✅ |
| Meta diária | ❌ | ✅ | ✅ |
| Fechar o dia | ❌ | ✅ | ✅ |
| Relatório por e-mail | ❌ | ✅ | ✅ |
| Módulo de convênio | ❌ | ❌ | ✅ |
| Múltiplos usuários | ❌ | ❌ | ✅ |
| Catálogo de produtos | ❌ | ❌ | ✅ |
| Suporte prioritário | ❌ | ❌ | ✅ |

> 30 dias de trial grátis no Gold · Sem contrato · Cancele quando quiser

---

## 🗺 Roadmap

- [x] CRUD completo (usuários, clientes, formas de pagamento, vendas)
- [x] Interface mobile-first do usuário final
- [x] Painel administrativo
- [x] Modo offline com sincronização
- [x] PWA instalável
- [x] Gráfico de 7 dias
- [x] Exportar resumo para WhatsApp
- [x] Landing page
- [ ] Controle de planos no backend
- [ ] Tela de upgrade e integração Mercado Pago
- [ ] Features Gold (score, limite de crédito, vencimento)
- [ ] Módulo de convênio (Premium)
- [ ] Múltiplos usuários por conta
- [ ] Catálogo de produtos com carrinho
- [ ] Notificações push
- [ ] App nativo via Capacitor

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Fork o repositório
2. Crie uma branch: `git checkout -b feat/minha-feature`
3. Commit: `git commit -m 'feat: adiciona minha feature'`
4. Push: `git push origin feat/minha-feature`
5. Abra um Pull Request

### Convenção de commits

| Prefixo | Uso |
|---|---|
| `feat:` | Nova funcionalidade |
| `fix:` | Correção de bug |
| `docs:` | Documentação |
| `style:` | Formatação sem mudança de lógica |
| `refactor:` | Refatoração de código |
| `chore:` | Tarefas auxiliares |

---

## 👨‍💻 Autor

**Gabriel Cardoso Fernandes**

[![GitHub](https://img.shields.io/badge/GitHub-GabrielCardoso--0-181717?style=flat-square&logo=github)](https://github.com/GabrielCardoso-0)
[![WhatsApp](https://img.shields.io/badge/Suporte-WhatsApp-25d366?style=flat-square&logo=whatsapp&logoColor=white)](https://wa.me/55984770085)

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

<div align="center">
  <p>Feito com ☕ para os pequenos comerciantes do Brasil</p>
  <p><strong>📒 E-Caderninho</strong> · Seu fiado no digital</p>
</div>

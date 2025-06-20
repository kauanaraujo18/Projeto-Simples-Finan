
# 💸 Simples Finan

**Simples Finan** é um sistema web de controle financeiro pessoal, com foco em simplicidade, organização e usabilidade. Ele permite o registro de movimentações financeiras (entradas e saídas), categorização por tipo, análise de saldo diário com gráficos dinâmicos, e autenticação de usuários.

## 🚀 Funcionalidades

- ✅ Cadastro e login de usuários
- ✅ Lançamento de movimentações (entradas e saídas)
- ✅ Categorização por categorias e subcategorias
- ✅ Gráfico dinâmico de saldo diário
- ✅ Consulta de extrato completo
- ✅ Visualização de saldo por data
- ✅ Interface web responsiva e minimalista (em desenvolvimento)
- ✅ Estrutura backend robusta em **Spring Boot**

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **HTML / CSS / JavaScript**
- **SQL Server** (banco de dados relacional)
- **Lombok** (para facilitar o desenvolvimento de entidades)
- **Maven** (gerenciador de dependências)
- **Thymeleaf** (opcional para views)
- **Chart.js** (para gráficos, no front-end)

---

## 🧱 Estrutura de Pastas

```
simples-finan/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── application/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   └── entity/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static / templates
└── README.md
```

---

## 📦 Como Executar o Projeto Localmente

### Pré-requisitos

- Java 17
- Maven instalado
- Banco de Dados SQL Server ativo
- Visual Studio Code ou IntelliJ IDEA

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/simples-finan.git
   ```

2. Configure o banco de dados:
   - Crie o banco conforme o script `database.sql` ou execute o script de criação das tabelas manuais.
   - Atualize as credenciais de conexão no `application.properties`.

3. Instale as dependências e execute:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse:
   ```
   http://localhost:8080
   ```

---

## 🔐 Login Inicial

Para testar o sistema, utilize um dos usuários cadastrados ou cadastre um novo via banco de dados.

---

## 🤝 Contribuição

Contribuições são bem-vindas!  
Se você deseja contribuir com melhorias, correções ou novos recursos, sinta-se à vontade para abrir uma *issue* ou *pull request*.

---

## 📄 Licença

Projeto desenvolvido por [Kauan Henrique de Araujo e Kauã Gouveia Netto] sob licença MIT.

---

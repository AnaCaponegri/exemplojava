# Sistema de Usuários — JavaFX

Projeto de estudos feito em **Java** com **JavaFX**, com telas de login e cadastro de usuários, conectado a um banco de dados **MySQL**.

---

## 📌 O que o projeto faz

- Tela de **login** (confere usuário e senha no banco)

- Tela de **cadastro** de novo usuário

- Depois do login, abre a **tela principal**

---

## 🛠️ Tecnologias usadas

- Java 21

- JavaFX 21

- Maven

- MySQL + MySQL Connector/J

---

## ▶️ Como rodar

**1. Criar o banco no MySQL:**

```sql
CREATE DATABASE sistema_usuarios;
```

**2. Configurar a conexão**

No arquivo `Conexao.java`, ajustar usuário, senha e porta do MySQL (padrão: `3306`).

**3. Rodar o projeto**

```bash
mvn clean javafx:run
```

---

## 🔑 Login de teste

```
Usuário: admin
Senha:   admin123
```

---

## 📂 Organização das pastas

| Pasta | O que tem |
|---|---|
| `controller` | Controla as telas |
| `dao` | Busca e salva dados no banco |
| `model` | Classe `Usuario` |
| `util` | Conexão, senha e sessão |
| `resources` | Telas `.fxml` e estilo `.css` |

Sistema de Usuários — JavaFX

Projeto de estudo desenvolvido em Java com JavaFX, contendo telas de login e cadastro de usuários, integrado a um banco de dados MySQL.

📌 Funcionalidades
Tela de login (valida usuário e senha no banco de dados)
Tela de cadastro de novo usuário
Acesso à tela principal após login realizado com sucesso
🛠️ Tecnologias
Java 21
JavaFX 21
Maven
MySQL + MySQL Connector/J (driver JDBC)
▶️ Como executar

1. Criar o banco de dados no MySQL:

sql
CREATE DATABASE sistema_usuarios;

2. Configurar a conexão

Edite o arquivo Conexao.java com usuário, senha e porta do seu MySQL (padrão: 3306).

3. Rodar o projeto

bash
mvn clean javafx:run
🔑 Login de teste
Usuário: admin
Senha:   admin123
📂 Estrutura do projeto
Pasta	Responsabilidade
controller	Controla as telas (login, cadastro, principal)
dao	Busca e salva dados no banco
model	Classe Usuario
util	Conexão com banco, hash de senha, controle de sessão
resources	Arquivos .fxml (telas) e .css (estilo)

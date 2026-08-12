package FirstFx.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import FirstFx.ExemploJava;
import FirstFx.dao.UsuarioDAO;
import FirstFx.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class CadastroUsuarioController {
@FXML private TextField campoNome;
@FXML private TextField campoLogin;
@FXML private TextField campoEmail;
@FXML private PasswordField campoSenha;
@FXML private PasswordField campoConfirmarSenha;
@FXML private ComboBox<String> comboPerfil;
@FXML private CheckBox checkAtivo;
@FXML private Label mensagem;
private final UsuarioDAO usuarioDAO = new UsuarioDAO();
@FXML private void initialize() {
comboPerfil.getItems().addAll("ADMIN", "GERENTE",
"FUNCIONARIO");
comboPerfil.setValue("FUNCIONARIO");
checkAtivo.setSelected(true);
}
@FXML private void salvar() {
String nome = campoNome.getText().trim();
String login = campoLogin.getText().trim();
String email = campoEmail.getText().trim();
String senha = campoSenha.getText();
String confirmar = campoConfirmarSenha.getText();
if (nome.isBlank() || login.isBlank() || email.isBlank() ||
senha.isBlank()) {
mensagem("Preencha todos os campos obrigatórios.", true);
return;
}
if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
mensagem("Informe um e-mail válido.", true); return;
}
if (senha.length() < 6) {
mensagem("A senha deve possuir pelo menos 6 caracteres.",
true); return;
}
if (!senha.equals(confirmar)) {
mensagem("As senhas não coincidem.", true); return;
}
Usuario usuario = new Usuario(0, nome, login, email,
comboPerfil.getValue(), checkAtivo.isSelected());
try {
usuarioDAO.cadastrar(usuario, senha);
limpar();
mensagem("Usuário cadastrado com sucesso.", false);
} catch (SQLIntegrityConstraintViolationException e) {
mensagem("O login ou o e-mail já está cadastrado.", true);
} catch (SQLException e) {
mensagem("Erro ao salvar no banco de dados.", true);
e.printStackTrace();
}
}
@FXML private void voltar() {
try { ExemploJava.trocarTela("/principal.fxml", 900, 580); }
catch (IOException e) { mensagem("Erro ao retornar à tela principal.", true); }
}
private void limpar() {
campoNome.clear(); campoLogin.clear(); campoEmail.clear();
campoSenha.clear(); campoConfirmarSenha.clear();
comboPerfil.setValue("FUNCIONARIO");
checkAtivo.setSelected(true);
}
private void mensagem(String texto, boolean erro) {
mensagem.setText(texto);
mensagem.getStyleClass().removeAll("mensagem-erro", "mensagemsucesso");
mensagem.getStyleClass().add(erro ? "mensagem-erro" :
"mensagem-sucesso");
}
}
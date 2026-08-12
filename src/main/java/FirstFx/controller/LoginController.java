package FirstFx.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import FirstFx.ExemploJava;
import FirstFx.dao.UsuarioDAO;
import FirstFx.model.Usuario;
import FirstFx.util.Sessao;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class LoginController {
@FXML private TextField campoLogin;
@FXML private PasswordField campoSenha;
@FXML private Label mensagem;
private final UsuarioDAO usuarioDAO = new UsuarioDAO();
@FXML
private void entrar() {
String login = campoLogin.getText().trim();
String senha = campoSenha.getText();
if (login.isBlank() || senha.isBlank()) {
exibirMensagem("Informe o login e a senha.", true);
return;
}
try {
Optional<Usuario> usuario = usuarioDAO.autenticar(login,
senha);
if (usuario.isPresent()) {
Sessao.setUsuarioLogado(usuario.get());
ExemploJava.trocarTela("/principal.fxml", 900, 580);
} else {
exibirMensagem("Login ou senha inválidos.", true);
}
} catch (SQLException e) {
exibirMensagem("Não foi possível conectar ao banco de dados.", true);
e.printStackTrace();
} catch (IOException e) {
exibirMensagem("Erro ao abrir a tela principal.", true);
e.printStackTrace();
}
}
private void exibirMensagem(String texto, boolean erro) {
mensagem.setText(texto);
mensagem.getStyleClass().removeAll("mensagem-erro", "mensagemsucesso");
mensagem.getStyleClass().add(erro ? "mensagem-erro" :
"mensagem-sucesso");
    }
}
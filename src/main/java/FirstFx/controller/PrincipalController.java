package FirstFx.controller;
import java.io.IOException;
import java.sql.SQLException;

import FirstFx.ExemploJava;
import FirstFx.dao.UsuarioDAO;
import FirstFx.model.Usuario;
import FirstFx.util.Sessao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class PrincipalController {
@FXML private Label labelBoasVindas;
@FXML private TableView<Usuario> tabelaUsuarios;
@FXML private TableColumn<Usuario, Integer> colunaId;
@FXML private TableColumn<Usuario, String> colunaNome;
@FXML private TableColumn<Usuario, String> colunaLogin;
@FXML private TableColumn<Usuario, String> colunaEmail;
@FXML private TableColumn<Usuario, String> colunaPerfil;
@FXML private TableColumn<Usuario, Boolean> colunaAtivo;
private final UsuarioDAO usuarioDAO = new UsuarioDAO();
@FXML
private void initialize() {
Usuario logado = Sessao.getUsuarioLogado();
labelBoasVindas.setText(logado == null ? "Bem-vindo" : "Olá, "
+ logado.getNome() + " — " + logado.getPerfil());
colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
colunaNome.setCellValueFactory(new
PropertyValueFactory<>("nome"));
colunaLogin.setCellValueFactory(new
PropertyValueFactory<>("login"));
colunaEmail.setCellValueFactory(new
PropertyValueFactory<>("email"));
colunaPerfil.setCellValueFactory(new
PropertyValueFactory<>("perfil"));
colunaAtivo.setCellValueFactory(new
PropertyValueFactory<>("ativo"));
atualizarTabela();
}
@FXML private void abrirCadastro() {
try { ExemploJava.trocarTela("/cadastro-usuario.fxml", 620,
650); }
catch (IOException e) { alerta("Erro", "Não foi possível abrir o cadastro."); }
}
@FXML private void atualizarTabela() {
try {
tabelaUsuarios.setItems(FXCollections.observableArrayList(usuarioDAO.listar())); }
catch (SQLException e) { alerta("Banco de dados", "Não foi possível listar os usuários."); }
}
@FXML private void sair() {
Sessao.encerrar();
try { ExemploJava.trocarTela("/login.fxml", 470, 540); }
catch (IOException e) { alerta("Erro", "Não foi possível retornar ao login."); }
}
private void alerta(String titulo, String texto) {
Alert alert = new Alert(Alert.AlertType.ERROR, texto,
ButtonType.OK);
alert.setTitle(titulo); alert.setHeaderText(null);
alert.showAndWait();
} 
}
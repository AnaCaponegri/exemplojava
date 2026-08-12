package FirstFx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import FirstFx.model.Usuario;
import FirstFx.util.Conexao;
import FirstFx.util.HashSenha;

public class UsuarioDAO {

    public Optional<Usuario> autenticar(String login, String senha)
            throws SQLException {
        String sql = "SELECT id, nome, login, email, perfil, ativo FROM usuarios " + "WHERE login = ? AND senha = ? AND ativo = TRUE";
try (Connection conexao = Conexao.conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, HashSenha.gerar(senha));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapear(rs));
                }
            }
        }
        return Optional.empty();
    }

    public void cadastrar(Usuario usuario, String senha) throws
            SQLException {
        String sql = "INSERT INTO usuarios (nome, login, email, senha,perfil, ativo) VALUES( ?,  ?,  ?,  ?,  ?,  ?)";
try (Connection conexao = Conexao.conectar(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, HashSenha.gerar(senha));
            ps.setString(5, usuario.getPerfil());
            ps.setBoolean(6, usuario.isAtivo());
            ps.executeUpdate();
        }
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id, nome, login, email, perfil, ativo FROM usuarios ORDER BY nome";
try (Connection conexao = Conexao.conectar(); PreparedStatement ps = conexao.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                usuarios.add(mapear(rs));
            }
        }
        return usuarios;
    }

    private Usuario mapear(ResultSet rs) throws SQLException {
        return new Usuario(rs.getInt("id"), rs.getString("nome"),
                rs.getString("login"),
                rs.getString("email"), rs.getString("perfil"),
                rs.getBoolean("ativo"));
    }
}

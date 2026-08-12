package FirstFx.util;
import FirstFx.model.Usuario;
public final class Sessao {
private static Usuario usuarioLogado;
private Sessao() {}
public static Usuario getUsuarioLogado() { return usuarioLogado; }
public static void setUsuarioLogado(Usuario usuario) {
usuarioLogado = usuario; }
public static void encerrar() { usuarioLogado = null; }
}
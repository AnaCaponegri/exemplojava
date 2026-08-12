package FirstFx.util;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public final class HashSenha {
private HashSenha() {}
public static String gerar(String senha) {
try {
MessageDigest digest = MessageDigest.getInstance("SHA256");
byte[] hash =
digest.digest(senha.getBytes(StandardCharsets.UTF_8));
StringBuilder resultado = new StringBuilder();
for (byte b : hash) resultado.append(String.format("%02x",
b));
return resultado.toString();
} catch (NoSuchAlgorithmException e) {
throw new IllegalStateException("SHA-256 não disponível.",
e);
}
}
}

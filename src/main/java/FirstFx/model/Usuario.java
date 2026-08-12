package FirstFx.model;

public class Usuario {

    private int id;
    private String nome;
    private String login;
    private String email;
    private String perfil;
    private boolean ativo;

    public Usuario() {
    }

    public Usuario(int id, String nome, String login, String email,
            String perfil, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.perfil = perfil;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    
    }
}

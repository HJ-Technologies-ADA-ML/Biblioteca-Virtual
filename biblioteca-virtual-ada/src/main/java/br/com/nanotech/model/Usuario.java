package br.com.nanotech.model;

public class Usuario extends Pessoa{
    private String email;
    private String senha;

    public Usuario(String nome, String dataNascimento, String email, String senha) {
        super(nome, dataNascimento);
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getTipo() {
        return "Usuario";
    }
}

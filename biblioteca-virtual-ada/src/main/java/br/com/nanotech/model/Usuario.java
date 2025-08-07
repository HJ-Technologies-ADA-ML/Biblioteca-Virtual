package br.com.nanotech.model;

public class Usuario extends Pessoa{
    private String email;
    private String senha;
    public Usuario(String nome, String dataNascimento) {
        super(nome, dataNascimento);
    }
    public void Usuario(String email, String senha){
     this.email = email;
     this.senha = senha;
    }

    @Override
    public String getTipo() {
        return "Usuario";
    }
}

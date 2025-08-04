package br.com.nanotech.model;

public class Editora {
    private String nome;
    private String endereco;

    public Editora(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return nome + " (" + endereco + ")";
    }
}

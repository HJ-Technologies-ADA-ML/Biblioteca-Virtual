package br.com.nanotech.model;


import java.util.ArrayList;
import java.util.List;

public class Autor extends Pessoa{
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome, String dataNascimento) {
        super(nome, dataNascimento);
    }


    public void adicionarLivro(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
            if (livro.getAutor() != this) {
                livro.setAutor(this);
            }
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String getTipo() {
        return "Author";
    }
}

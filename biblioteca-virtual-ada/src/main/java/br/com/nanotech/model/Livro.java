package br.com.nanotech.model;


public class Livro {
    private String titulo;
    private String dataPublicacao;
    private String resumo;
    private Autor autor;  // apenas um autor
    private Editora editora;

    public Livro(String titulo, String dataPublicacao, String resumo) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.resumo = resumo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
        if (!autor.getLivros().contains(this)) {
            autor.adicionarLivro(this);
        }
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editora getEditora() {
        return editora;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo +
                "\nPublicado em: " + dataPublicacao +
                "\nResumo: " + resumo +
                "\nAutor: " + (autor != null ? autor.getNome() : "Não definido") +
                "\nEditora: " + (editora != null ? editora.getNome() : "Não definida");
    }
}

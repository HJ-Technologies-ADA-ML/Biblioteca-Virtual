package br.com.nanotech.model;


public class Livro {
    private String titulo;
    private String anoPublicacao;
    private String resumo;
    private Editora editora;

    public Livro(String titulo, String anoPublicacao, String resumo, Editora editora) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.resumo = resumo;
        this.editora = editora;
    }


 /*  public void setAutor(Autor autor) {
        if (!autor.getLivros().contains(this)) {
            autor.adicionarLivro(this);
        }
    }*/


    public String getAnoPublicacao() {
        return anoPublicacao;
    }


    public String getResumo() {
        return resumo;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }


    public Editora getEditora() {
        return editora;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo +
                "\nPublicado em: " + anoPublicacao +
                "\nResumo: " + resumo +
                "\nEditora: " + (editora != null ? editora.getNome() : "Não definida");
    }
}

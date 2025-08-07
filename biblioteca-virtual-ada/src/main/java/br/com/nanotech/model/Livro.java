package br.com.nanotech.model;


public class Livro {
    private String titulo;
    private String dataPublicacao;
    private String resumo;
    private Editora editora;

    public Livro(String titulo, String dataPublicacao, String resumo) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.resumo = resumo;
    }

 /*  public void setAutor(Autor autor) {
        if (!autor.getLivros().contains(this)) {
            autor.adicionarLivro(this);
        }
    }*/


    public String getDataPublicacao() {
        return dataPublicacao;
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
                "\nPublicado em: " + dataPublicacao +
                "\nResumo: " + resumo +
                "\nEditora: " + (editora != null ? editora.getNome() : "Não definida");
    }
}

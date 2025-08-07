package br.com.nanotech.controller;

import br.com.nanotech.model.Autor;
import br.com.nanotech.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivrosController {

    private List<Autor> autores = new ArrayList<>();

    public LivrosController() {
        Autor autor1 = new Autor("Machado de Assis", "21/06/1839");
        autor1.adicionarLivro(new Livro("Dom Casmurro", "1899", "Romance sobre ciúmes e memórias"));
        autor1.adicionarLivro(new Livro("Memórias Póstumas de Brás Cubas", "1881", "Narrado por um defunto"));
        autor1.adicionarLivro(new Livro("Quincas Borba", "1891", "História de Rubião e filosofia Humanitas"));

        Autor autor2 = new Autor("J.K. Rowling", "31/07/1965");
        autor2.adicionarLivro(new Livro("Harry Potter e a Pedra Filosofal", "1997", "Primeira aventura de Harry"));
        autor2.adicionarLivro(new Livro("Harry Potter e a Câmara Secreta", "1998", "Segunda aventura de Harry"));

        Autor autor3 = new Autor("George Orwell", "25/06/1903");
        autor3.adicionarLivro(new Livro("1984", "1949", "Distopia sobre vigilância e totalitarismo"));
        autor3.adicionarLivro(new Livro("A Revolução dos Bichos", "1945", "Fábula política e crítica ao autoritarismo"));

        Autor autor4 = new Autor("Clarice Lispector", "10/12/1920");
        autor4.adicionarLivro(new Livro("A Hora da Estrela", "1977", "História de Macabéa"));
        autor4.adicionarLivro(new Livro("Laços de Família", "1960", "Coletânea de contos"));
        autor4.adicionarLivro(new Livro("Perto do Coração Selvagem", "1943", "Romance de estreia"));

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);
    }

    public void exibirAutoresELivros() {
        for (Autor autor : autores) {
            System.out.println("\n" + autor.getNome() + " escreveu:");
            for (Livro livro : autor.getLivros()) {
                System.out.println(" - " + livro.getTitulo() + " (" + livro.getDataPublicacao() + ")");
            }
        }
    }

    public List<Autor> getAutores() {
        return autores;
    }
}

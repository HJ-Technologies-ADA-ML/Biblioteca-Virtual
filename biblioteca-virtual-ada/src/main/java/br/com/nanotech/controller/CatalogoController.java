package br.com.nanotech.controller;

import br.com.nanotech.model.Autor;
import br.com.nanotech.model.Editora;
import br.com.nanotech.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class CatalogoController {

    private List<Autor> autores = new ArrayList<>();

    public CatalogoController() {
        carregarCatalogo();
    }

    public void carregarCatalogo() {
        Editora editora1 = new Editora("Companhia das Letras", "Av. Paulista, 2073 - Bela Vista, São Paulo - SP");
        Editora editora2 = new Editora("Bloomsbury", "50 Bedford Square, London WC1B 3DP, Reino Unido");
        Editora editora3 = new Editora("Secker & Warburg", "20 Vauxhall Bridge Rd, Westminster, Londres, Reino Unido");
        Editora editora4 = new Editora("Rocco", "Rua do Russel, 804 - Glória, Rio de Janeiro - RJ");


        Autor autor1 = new Autor("Machado de Assis", "21/06/1839");
        autor1.adicionarLivro(new Livro("Dom Casmurro", "1899", "Romance sobre ciúmes e memórias", editora1));
        autor1.adicionarLivro(new Livro("Memórias Póstumas de Brás Cubas", "1881", "Narrado por um defunto", editora1));
        autor1.adicionarLivro(new Livro("Quincas Borba", "1891", "História de Rubião e filosofia Humanitas", editora1));

        Autor autor2 = new Autor("J.K. Rowling", "31/07/1965");
        autor2.adicionarLivro(new Livro("Harry Potter e a Pedra Filosofal", "1997", "Primeira aventura de Harry", editora2));
        autor2.adicionarLivro(new Livro("Harry Potter e a Câmara Secreta", "1998", "Segunda aventura de Harry", editora2));

        Autor autor3 = new Autor("George Orwell", "25/06/1903");
        autor3.adicionarLivro(new Livro("1984", "1949", "Distopia sobre vigilância e totalitarismo", editora3));
        autor3.adicionarLivro(new Livro("A Revolução dos Bichos", "1945", "Fábula política e crítica ao autoritarismo", editora3));

        Autor autor4 = new Autor("Clarice Lispector", "10/12/1920");
        autor4.adicionarLivro(new Livro("A Hora da Estrela", "1977", "História de Macabéa", editora4));
        autor4.adicionarLivro(new Livro("Laços de Família", "1960", "Coletânea de contos", editora4));
        autor4.adicionarLivro(new Livro("Perto do Coração Selvagem", "1943", "Romance de estreia", editora4));

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);
    }


    public void exibirAutoresEditorasELivros() {
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado no catálogo.");
            return;
        }

        System.out.println("\n=== CATÁLOGO DE AUTORES, EDITORAS E LIVROS ===");
        for (Autor autor : autores) {
            System.out.printf("\nAutor: %s (nasc. %s) - %d livro(s):",
                    autor.getNome(),
                    autor.getDataNascimento(),
                    autor.getLivros().size());

            autor.getLivros().forEach(livro -> {
                String nomeEditora = livro.getEditora() != null ? livro.getEditora().getNome() : "Sem editora";
                String enderecoEditora = livro.getEditora() != null ? livro.getEditora().getEndereco() : "Endereço não informado";

                System.out.printf("\n  - %s (%s): %s \n    Editora: %s (%s)",
                        livro.getTitulo(),
                        livro.getDataPublicacao(),
                        livro.getResumo(),
                        nomeEditora,
                        enderecoEditora);
            });
        }
        System.out.println("\n\nTotal de autores: " + autores.size());
    }

    public List<Autor> getAutores() {
        return autores;
    }
}

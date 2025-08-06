package br.com.nanotech.controller;

import br.com.nanotech.model.Autor;
import br.com.nanotech.model.Editora;
import br.com.nanotech.model.Livro;

import java.util.List;

public class BibliotecaController {
    private List<Livro> livros;
    private List<Autor> autores;
    private List<Editora> editoras;

    public BibliotecaController(List<Livro> livros, List<Autor> autores, List<Editora> editoras) {
        this.livros = livros;
        this.autores = autores;
        this.editoras = editoras;
    }

    public void listarTodosLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
            System.out.println("--------------------");
        }
    }

    public void buscarLivroPorTitulo(String titulo) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(livro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public void listarLivrosPorAutor(String nomeAutor) {
        boolean encontrado = false;
        for (Autor autor : autores) {
            if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
                for (Livro livro : autor.getLivros()) {
                    System.out.println(livro);
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Autor não encontrado.");
        }
    }

    public void listarLivrosPorEditora(String nomeEditora) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getEditora().getNome().equalsIgnoreCase(nomeEditora)) {
                System.out.println(livro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado para essa editora.");
        }
    }
}

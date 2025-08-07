package br.com.nanotech.controller;

import br.com.nanotech.model.Autor;
import br.com.nanotech.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    private List<Livro> livros;
    private List<Autor> autores;

    public BibliotecaController() {
        this.autores = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public void listarTodosLivros() {
        System.out.println("\n📚 TODOS OS LIVROS:");
        for (Livro livro : livros) {
            System.out.println(livro);
            System.out.println("--------------------");
        }
    }

    public List<Livro> buscarPorAutor(String nomeAutor) {
        List<Livro> encontrados = new ArrayList<>();
        for (Autor autor : autores) {
            if (autor.getNome().toLowerCase().contains(nomeAutor.toLowerCase())) {
                encontrados.addAll(autor.getLivros());
            }
        }
        return encontrados;
    }

    public List<Livro> buscarPorAno(String ano) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao().equals(ano)) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    public List<Livro> buscarPorTitulo(String termo) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    public void listarLivrosPorAutor(String nomeAutor) {
        System.out.println("\n📖 LIVROS DO AUTOR '" + nomeAutor + "':");
        boolean encontrado = false;
        for (Autor autor : autores) {
            if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
                for (Livro livro : autor.getLivros()) {
                    System.out.println(livro);
                    System.out.println("--------------------");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Autor não encontrado.");
        }
    }
}

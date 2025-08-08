package br.com.nanotech.controller;

import br.com.nanotech.model.Autor;
import br.com.nanotech.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    private List<Livro> livros;
    private List<Autor> autores;

    // recebe o CatalogoController para acessar os dados reais
    public BibliotecaController(CatalogoController catalogoController) {
        this.autores = catalogoController.getAutores();
        this.livros = new ArrayList<>();
        for (Autor autor : autores) {
            this.livros.addAll(autor.getLivros());
        }
    }

    public void listarTodosLivros() {
        System.out.println("\n📚 TODOS OS LIVROS:");
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (Livro livro : livros) {
            System.out.println(livro);
            System.out.println("--------------------");
        }
    }

    public List<Livro> buscarPorAutor(String nomeAutor) {
        List<Livro> encontrados = new ArrayList<>();
        for (Autor autor : autores) {
            if (autor.getNome() != null && autor.getNome().toLowerCase().contains(nomeAutor.toLowerCase())) {
                encontrados.addAll(autor.getLivros());
            }
        }
        return encontrados;
    }

    public List<Livro> buscarPorAno(String ano) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao() != null && livro.getDataPublicacao().equals(ano)) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    public List<Livro> buscarPorTitulo(String termo) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo() != null && livro.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

}

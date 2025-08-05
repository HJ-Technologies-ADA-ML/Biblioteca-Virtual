package br.com.nanotech.controller;

import br.com.nanotech.model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroController {
    private List<Livro> livros = new ArrayList<>();

    public void carregarLivros() {
    livros.add(new Livro("Dom Casmurro", "05/05/1800", "Romance clássico brasileiro.", null, null));
        livros.add(new Livro("Dom Casmurro", "05/05/1800", "Romance clássico brasileiro.", null, null));
        livros.add(new Livro("Dom Casmurro", "05/05/1800", "Romance clássico brasileiro.", null, null));
        livros.add(new Livro("Dom Casmurro", "05/05/1800", "Romance clássico brasileiro.", null, null));
        livros.add(new Livro("Dom Casmurro", "05/05/1800", "Romance clássico brasileiro.", null, null));
        livros.add(new Livro("Dom Casmurro", "05/05/1800", "Romance clássico brasileiro.", null, null));

    }
    public LivroController() {
        this.livros = new ArrayList<>();

    }

    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }

    public List<Livro> buscarPorNome(String nome) {
        String nomeLower = nome.toLowerCase();
        return livros.stream()
                .filter(l -> l.getTitulo() != null && l.getTitulo().toLowerCase().contains(nomeLower))
                .collect(Collectors.toList());
    }
}


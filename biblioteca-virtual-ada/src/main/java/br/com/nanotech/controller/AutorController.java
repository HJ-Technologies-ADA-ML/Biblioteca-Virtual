package br.com.nanotech.controller;

import br.com.nanotech.model.Autor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutorController {
    private List<Autor> autores;

    public AutorController() {
        this.autores = new ArrayList<>();
    }

    public void adicionar(Autor autor) {
        autores.add(autor);
    }

    public List<Autor> listarTodos() {
        return new ArrayList<>(autores);
    }

    public List<Autor> buscarPorNome(String nome) {
        String nomeLower = nome.toLowerCase();
        return autores.stream()
                .filter(a -> a.getNome() != null && a.getNome().toLowerCase().contains(nomeLower))
                .collect(Collectors.toList());
    }
}


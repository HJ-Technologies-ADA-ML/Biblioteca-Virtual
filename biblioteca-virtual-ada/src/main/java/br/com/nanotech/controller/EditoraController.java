package br.com.nanotech.controller;

import br.com.nanotech.model.Editora;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditoraController {
    private List<Editora> editoras;

    public EditoraController() {
        this.editoras = new ArrayList<>();
    }

    public void adicionar(Editora editora) {
        editoras.add(editora);
    }

    public List<Editora> listarTodos() {
        return new ArrayList<>(editoras);
    }

    public List<Editora> buscarPorNome(String nome) {
        String nomeLower = nome.toLowerCase();
        return editoras.stream()
                .filter(e -> e.getNome() != null && e.getNome().toLowerCase().contains(nomeLower))
                .collect(Collectors.toList());
    }
}


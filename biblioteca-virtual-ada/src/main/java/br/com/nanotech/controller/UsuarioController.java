package br.com.nanotech.controller;

import br.com.nanotech.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UsuarioController {
    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());
    private final List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioLogado;

    public void cadastrarUsuario(Usuario usuario) {
        if (buscarPorEmail(usuario.getEmail()) != null) {
            logger.warning("Tentativa de cadastro com email já existente: " + usuario.getEmail());
            return;
        }
        this.usuarios.add(usuario);
        System.out.println("Cadastro realizado com sucesso!");
    }

    public boolean login(String email, String senha) {
        Usuario usuario = buscarPorEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            this.usuarioLogado = usuario;
            return true;
        }
        return false;
    }

    private Usuario buscarPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }

}

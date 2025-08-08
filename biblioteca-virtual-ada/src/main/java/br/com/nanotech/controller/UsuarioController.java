package br.com.nanotech.controller;

import br.com.nanotech.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UsuarioController {
    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());
    private final List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioLogado;

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

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
        if (usuario != null && usuario.getSenha() != null && usuario.getSenha().equals(senha)) {
            this.usuarioLogado = usuario;
            return true;
        }
        return false;
    }

    public Usuario buscarPorEmail(String email) {
        System.out.println("Buscando usuário com email: " + email);
        for (Usuario usuario : usuarios) {
            System.out.println("Verificando usuário: " + usuario.getEmail());
            if (usuario.getEmail() != null && usuario.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Usuário encontrado: " + usuario.getEmail());
                return usuario;
            }
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }
}

package br.com.nanotech.controller;

import br.com.nanotech.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import br.com.nanotech.ultilities.Helper;

public class UsuarioController {
    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());
    private final List<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioLogado;

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    private boolean isEmailValido(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            logger.warning("Tentativa de cadastro com nome vazio." + usuario.getNome());
            System.out.println("Nome inválido. Por favor, insira um nome válido.");
            return;
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            logger.warning("Tentativa de cadastro com email vazio." + usuario.getEmail());
            System.out.println("Email inválido. Por favor, insira um email válido.");
            return;
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            logger.warning("Tentativa de cadastro com senha vazia." + usuario.getSenha());
            System.out.println("Senha inválida. Por favor, insira uma senha válida.");
            return;
        }

        if (usuario.getDataNascimento() == null || usuario.getDataNascimento().isEmpty()) {
            logger.warning("Tentativa de cadastro com data de nascimento vazia." + usuario.getDataNascimento());
            System.out.println("Data de nascimento inválida. Por favor, insira uma data válida no formato dd/MM/yyyy.");
            return;
        }

        if (!Helper.isDataValida(usuario.getDataNascimento())) {
            logger.warning("Tentativa de cadastro com data de nascimento inválida: " + usuario.getDataNascimento());
            System.out.println("Data de nascimento inválida. Por favor, insira uma data válida no formato dd/MM/yyyy.");
            return;
        }

        if (!isEmailValido(usuario.getEmail())) {
            logger.warning("Tentativa de cadastro com email inválido: " + usuario.getEmail());
            System.out.println("Email inválido. Por favor, insira um email válido.");
            return;
        }

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

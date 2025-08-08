package br.com.nanotech.view;

import br.com.nanotech.controller.BibliotecaController;
import br.com.nanotech.controller.CatalogoController;
import br.com.nanotech.controller.UsuarioController;
import br.com.nanotech.model.Usuario;

import java.util.Scanner;

public class UsuarioView {

    private static final Scanner in = new Scanner(System.in);
    private CatalogoController catalogoController;
    private UsuarioController usuarioController;
    private BibliotecaController bibliotecaController;

    public UsuarioView(CatalogoController catalogoController, UsuarioController usuarioController, BibliotecaController bibliotecaController) {
        this.catalogoController = catalogoController;
        this.usuarioController = usuarioController;
        this.bibliotecaController = bibliotecaController;
    }

    public void exibirMenuCliente() {
        catalogoController.carregarCatalogo();
        int opcao = -1;

        do {
            System.out.println("\n== Menu Usuário ==");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Fazer Login");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1; // opção inválida
            }

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    fazerLogin();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void fazerLogin() {
        System.out.print("Digite seu email: ");
        String email = in.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = in.nextLine();

        boolean sucesso = usuarioController.login(email, senha);
        if (sucesso) {
            System.out.println("Login realizado com sucesso!");
            Usuario usuarioLogado = usuarioController.getUsuarioLogado();
            catalogoController.setUsuarioLogado(usuarioLogado);
            BibliotecaView bibliotecaView = new BibliotecaView(bibliotecaController, catalogoController);
            bibliotecaView.exibirMenu();
        } else {
            System.out.println("Email ou senha inválidos.");
        }
    }

    private void cadastrarUsuario() {
        System.out.print("Digite seu nome completo: ");
        String nome = in.nextLine();
        System.out.print("Digite sua data de nascimento (DD/MM/AAAA): ");
        String dataNascimento = in.nextLine();
        System.out.print("Digite seu email: ");
        String email = in.nextLine();
        System.out.print("Digite uma senha: ");
        String senha = in.nextLine();

        Usuario usuario = new Usuario(nome, dataNascimento, email, senha);
        usuarioController.cadastrarUsuario(usuario);
    }
}

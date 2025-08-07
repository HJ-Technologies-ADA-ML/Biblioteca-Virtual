package br.com.nanotech.view;

import br.com.nanotech.controller.BibliotecaController;
import br.com.nanotech.controller.CatalogoController;
import br.com.nanotech.controller.UsuarioController;

import java.util.Scanner;

public class UsuarioView {

    private static final Scanner in = new Scanner(System.in);
    private CatalogoController catalogoController = new CatalogoController();

    public UsuarioView(CatalogoController catalogoController) {
        this.catalogoController = catalogoController;
    }

    public void exibirMenuCliente() {
        catalogoController.carregarCatalogo();
        int opPrincipal;
        do {
            System.out.println("\n==== Biblioteca Nano-Tech ====\n");
            System.out.println("1 - Cadastrar Usuario ");
            System.out.println("2 - Login");
            System.out.println("0 - Sair\n");
            System.out.print("Escolha: ");

            try {
                opPrincipal = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                opPrincipal = -1;
            }

            switch (opPrincipal) {
                case 1 -> cadastrarUsuario();
                case 2 -> fazerLogin();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opPrincipal != 0);
    }

    private void fazerLogin() {
    }

    private void cadastrarUsuario() {
    }
}

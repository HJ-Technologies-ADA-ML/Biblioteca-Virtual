package br.com.nanotech.view;

import br.com.nanotech.controller.BibliotecaController;

import java.util.Scanner;

public class BibliotecaView {
    private BibliotecaController controller;
    private Scanner in = new Scanner(System.in);

    public BibliotecaView(BibliotecaController controller) {
        this.controller = controller;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("=== Menu Biblioteca ===");
            System.out.println("1 - Listar todos os livros");
            System.out.println("2 - Buscar livro por título");
            System.out.println("3 - Listar livros por autor");
            System.out.println("4 - Listar livros por editora");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = in.nextInt();
            in.nextLine();

            switch (opcao) {
                case 1:
                    controller.listarTodosLivros();
                    break;
                case 2:
                    System.out.print("Digite o título: ");
                    controller.buscarLivroPorTitulo(in.nextLine());
                    break;
                case 3:
                    System.out.print("Digite o nome do autor: ");
                    controller.listarLivrosPorAutor(in.nextLine());
                    break;
                case 4:
                    System.out.print("Digite o nome da editora: ");
                    controller.listarLivrosPorEditora(in.nextLine());
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}

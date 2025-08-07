package br.com.nanotech.view;

import br.com.nanotech.controller.BibliotecaController;
import br.com.nanotech.model.Livro;

import java.util.List;
import java.util.Scanner;

public class BibliotecaView {
    private BibliotecaController bibliotecaController;
    private Scanner in = new Scanner(System.in);

    public BibliotecaView(BibliotecaController bibliotecaController) {
        this.bibliotecaController = bibliotecaController;
    }

    public void exibirMenu() {
        int op;
        do {
            System.out.println("\n=== BIBLIOTECA VIRTUAL ===");
            System.out.println("1 - Listar todos os livros");
            System.out.println("2 - Buscar por título");
            System.out.println("3 - Buscar por autor");
            System.out.println("4 - Buscar por ano de publicação");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            op = in.nextInt();
            in.nextLine();

            switch (op) {
                case 1 -> bibliotecaController.listarTodosLivros();
                case 2 -> buscarPorTitulo();
                case 3 -> buscarPorAutor();
                case 4 -> buscarPorAno();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private void buscarPorTitulo() {
        System.out.print("Digite parte do título: ");
        String termo = in.nextLine();
        mostrarResultados(bibliotecaController.buscarPorTitulo(termo));
    }

    private void buscarPorAutor() {
        System.out.print("Digite parte do nome do autor: ");
        String nome = in.nextLine();
        mostrarResultados(bibliotecaController.buscarPorAutor(nome));
    }

    private void buscarPorAno() {
        System.out.print("Digite o ano de publicação: ");
        String ano = in.nextLine();
        mostrarResultados(bibliotecaController.buscarPorAno(ano));
    }

    private void mostrarResultados(List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("\n📖 RESULTADOS:");
            for (Livro livro : livros) {
                System.out.println(livro);
                System.out.println("--------------------");
            }
            System.out.println("Total encontrado: " + livros.size());
        }
    }
}

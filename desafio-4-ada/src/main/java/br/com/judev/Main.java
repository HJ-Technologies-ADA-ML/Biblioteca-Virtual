package br.com.judev;

import br.com.judev.model.Conta;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Conta conta1 = new Conta("João", 123, 1000.00);
        // Exemplo para transferência
        Conta conta2 = new Conta("Maria", 456, 500.00);

        while (true) {
            System.out.println("\n=== MENU BANCÁRIO ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Pagar");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 5) {
                System.out.println("Saindo... Obrigado!");
                break;
            }

            System.out.print("Valor: R$ ");
            double valor = scanner.nextDouble();

            switch (opcao) {
                case 1: if (conta1.depositar(valor)) {
                        System.out.println("Depósito realizado.");
                    } else {
                        System.out.println("Valor inválido.");
                    }break;

                case 2: if (conta1.sacar(valor)) {
                        System.out.println("Saque realizado.");
                    } else {
                        System.out.println("Saldo insuficiente ou valor inválido.");
                    }break;

                case 3: if (conta1.transferir(valor, conta2)) {
                        System.out.println("Transferência realizada para " + conta2.getTitular());
                    } else {
                        System.out.println("Saldo insuficiente para transferir.");
                    }break;

                case 4:
                    if (conta1.pagar(valor)) {
                        System.out.println("Pagamento efetuado.");
                    } else {
                        System.out.println("Saldo insuficiente para pagamento.");
                    }break;

                default: System.out.println("Opção inválida.");
            }
            conta1.mostrarSaldo();
        }
    }
}
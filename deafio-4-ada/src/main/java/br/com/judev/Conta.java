package br.com.judev;

public class Conta {
    private String titular;
    private int numero;
    private double saldo;

    private static final double TAXA = 0.50;

    public Conta(String titular, int numero, double saldoInicial) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor - TAXA;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor + TAXA <= saldo && valor > 0) {
            saldo -= (valor + TAXA);
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor); // destino também pagará taxa
            return true;
        }
        return false;
    }

    public boolean pagar(double valor) {
        return sacar(valor); // mesma lógica do saque
    }

    public void mostrarSaldo() {
        System.out.printf("Saldo atual de %s (Conta %d): R$ %.2f\n", titular, numero, saldo);
    }

    public String getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}

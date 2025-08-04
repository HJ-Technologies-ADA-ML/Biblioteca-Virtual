package br.com.judev.model;

public class Conta {
    private String titular;
    private double saldo;
    private int numero;
    private static final double TAXA = 0.50;

    public Conta(String titular, int numero, double saldoInicial) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public boolean depositar(double valor){
        if(valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor){
        if(valor + TAXA <= saldo && valor > 0){
            saldo -= (valor + TAXA);
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta destino){
        if(sacar(valor)){
            destino.depositar(valor);
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

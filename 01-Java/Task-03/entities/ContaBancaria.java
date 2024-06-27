package task03.entities;

public class ContaBancaria {

    private String numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria() {
    }

    public ContaBancaria(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor < 0) {
            System.out.println("Não é permitido despositar valores negativos.");
            return;
        }
        setSaldo(getSaldo() + valor);
        System.out.println("Você depositou R$" + valor + ", seu saldo atual é de: R$" + getSaldo());

    }

    public void sacar(double valor) {
        if (valor < 0) {
            System.out.println("Não é permitido sacar valores negativos.");
            return;
        }
        if (valor > getSaldo()) {
            System.out.println("Valor de saque maior que o valor em conta.");
        } else {
            setSaldo(getSaldo() - valor);
            System.out.println("Você sacou R$" + valor + ", seu saldo atual é de: R$" + getSaldo());
        }
    }
}

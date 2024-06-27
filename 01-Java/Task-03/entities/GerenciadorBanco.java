package task03.entities;

import java.util.List;


public class GerenciadorBanco {

    private List<ContaBancaria> contaBancariaList;

    public GerenciadorBanco(List<ContaBancaria> contaBancariaList) {
        this.contaBancariaList = contaBancariaList;
    }

    public void adicionarConta(ContaBancaria conta) {

        boolean contaExiste = false;
        for (ContaBancaria cb : contaBancariaList) {
            if (cb.getNumeroConta().equals(conta.getNumeroConta())) {
                contaExiste = true;
                break;
            }
        }
        if (!contaExiste) {
            contaBancariaList.add(conta);
            System.out.println("Conta: " + conta.getNumeroConta() + " adicionada com sucesso!");

        } else {
            System.out.println("Erro: Já existe uma conta com o numero " + conta.getNumeroConta());
        }

    }

    public void removerConta(String numeroConta) {
        boolean removido = contaBancariaList.removeIf(cb -> cb.getNumeroConta().equals(numeroConta));

        if (removido) {
            System.out.println("Conta com número " + numeroConta + " removida com sucesso.");
        } else {
            System.out.println("Conta com número " + numeroConta + " não encontrada.");
        }
    }

    public ContaBancaria buscarConta(String numeroConta) {

        boolean contaExiste = false;
        for (ContaBancaria cb : contaBancariaList) {
            if (cb.getNumeroConta().equals(numeroConta)) {
                System.out.println("Conta encontrada:");
                System.out.printf("""
                    Numero da conta: %s
                    Tiular da conta: %s
                    Saldo da conta: R$%.2f 
                    
                    """, cb.getNumeroConta() , cb.getTitular(), cb.getSaldo());


                contaExiste = true;
                return cb;
            }
        }

        if (!contaExiste) {
            System.out.println("Conta não encontrada.");
        }

        return null;
    }

    public void listarConta() {
        for (ContaBancaria conta : contaBancariaList) {
            System.out.printf("""
                    Numero da conta: %s
                    Tiular da conta: %s
                    Saldo da conta: R$%.2f 
                    
                    """, conta.getNumeroConta() , conta.getTitular(), conta.getSaldo());

        }
    }

}

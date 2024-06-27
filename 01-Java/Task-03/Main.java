package task03;

import task03.entities.ContaBancaria;
import task03.entities.GerenciadorBanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<ContaBancaria> contaBancariaList = new ArrayList<>();

        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(contaBancariaList);

        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta;

        while (true) {
            System.out.println("""
                    =====================
                    | 1 - Criar conta   |
                    | 2 - Apagar conta  |
                    | 3 - Buscar conta  |
                    | 4 - Listar contas |
                    | 5 - Sacar         |
                    | 6 - Depositar     |
                    | 7 - Sair          |
                    =====================
                    """);
            int opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Qual o nome do o titular da conta?");
                    String titular = scanner.nextLine();

                    System.out.println("Digite o número da conta: ");
                    String numero = scanner.nextLine();

                    System.out.println("Qual é o valor do saldo?");
                    double saldo = scanner.nextDouble();

                    gerenciadorBanco.adicionarConta(new ContaBancaria(numero, titular, saldo));
                    break;
                case 2:
                    System.out.println("Digite o número da conta que deseja remover: ");
                    gerenciadorBanco.removerConta(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Qual o número da sua conta? ");
                    gerenciadorBanco.buscarConta(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Essas são todas as contas cadastradas:\n");
                    gerenciadorBanco.listarConta();
                    break;
                case 5:
                    System.out.println("Qual o número da sua conta? ");
                    conta = gerenciadorBanco.buscarConta(scanner.nextLine());
                    System.out.println("Quanto deseja sacar? ");
                    conta.sacar(scanner.nextDouble());
                    break;
                case 6:
                    System.out.println("Qual o número da sua conta? ");
                    conta = gerenciadorBanco.buscarConta(scanner.nextLine());
                    System.out.println("Quanto deseja depositar? ");
                    conta.depositar(scanner.nextDouble());
                    break;
                case 7:
                    return;
            }
        }
    }
}
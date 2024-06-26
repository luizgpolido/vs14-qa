package task02;

import java.util.Scanner;

public class Atividade03{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nomeProduto = sc.nextLine();

        System.out.print("Digite o valor do produto: ");
        double precoProduto = sc.nextDouble();

        System.out.printf("\nProduto: %s \nPreço: R$ %.2f\n", nomeProduto, precoProduto);
        for (int quantidade = 1; quantidade <= 10; quantidade++) {
            double desconto = Math.min(quantidade * 5, 50);
            double precoComDesconto = precoProduto * (1 - desconto / 100);
            System.out.printf("%d unidade(s): R$ %.2f = R$ %.2f (desconto de %.0f%%)%n", quantidade, precoComDesconto,  (precoComDesconto * quantidade) , desconto);
        }
    }
}

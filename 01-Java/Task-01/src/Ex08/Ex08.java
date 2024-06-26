package Ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Produto> produtoList = new ArrayList<>();
        int escolhaMenu = 0;

        while (escolhaMenu < 5) {
            System.out.println("=======================");
            System.out.println("MENU DE OPÇÕES");
            System.out.println("1- Cadastrar Produto");
            System.out.println("2- Aplicar Desconto");
            System.out.println("3- Exibir Produtos");
            System.out.println("4- Exibir Produto Especifico");
            System.out.println("5- Encerrar Programa");
            System.out.println("=======================");
            escolhaMenu = sc.nextInt();
            sc.nextLine(); //consome quebra de linha

            switch (escolhaMenu) {
                case 1:
                    System.out.println("Insira o nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.println("Insira a descrição do produto: ");
                    String descricao = sc.nextLine();
                    System.out.println("Insira o preço do produto: ");
                    double preco = sc.nextDouble();
                    System.out.println("Insira o estoque do produto: ");
                    int estoque = sc.nextInt();
                    produtoList.add(new Produto(nome, descricao, preco, estoque));
                    break;
                case 2:
                    System.out.println("Insira o nome exato do produto: ");
                    String nomeProduto = sc.nextLine();
                    Produto prod = produtoList.stream().filter(x -> x.getNome().equals(nomeProduto)).findFirst().orElse(null);
                    if (prod == null) {
                        System.out.println("Produto não existe");
                    } else {
                        System.out.println("Insira o desconto: ");
                        double desconto = sc.nextDouble();
                        prod.aplicarDesconto(desconto);

                    }
                    break;
                case 3:
                    System.out.println("Exibindo todos os produtos: ");
                    for (Produto p : produtoList) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    System.out.println("Insira o nome exato do produto: ");
                    String nomeProdutoPesq = sc.nextLine();
                    Produto prodPesq = produtoList.stream().filter(x -> x.getNome().equals(nomeProdutoPesq)).findFirst().orElse(null);
                    if (prodPesq == null) {
                        System.out.println("Produto não existe.");
                    } else {
                        System.out.println(prodPesq);
                    }
                    break;
            }
        }

        System.out.println("Sistema encerrado.");
    }


}

import entities.Customer;
import entities.CustomerShoppingBag;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Customer> customersList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        String name;
        String email;
        int stock;

        while (true) {
            System.out.println("""
                    =======================
                    | 1 - Criar conta     |
                    | 2 - Acessar conta   | 
                    | 3 - Criar Produto   | 
                    | 4 - Deletar Produto | 
                    | 5 - Sair da loja    |
                    =======================
                    """);
            int opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    System.out.print("Insira o nome da conta: ");
                    name = scanner.nextLine();
                    System.out.print("Insira o nome do email: "); ///Validar se já existe esse email cadastrado
                    email = scanner.nextLine();
                    // Lista de Clientes instanciada com uma lista de produtos dentro dela, consultar CustomerShoppingBag para entender
                    // Usando upcasting da CustomerShoppingBag na Lista do tipo Customer
                    customersList.add(new CustomerShoppingBag(name, email, new ArrayList<Product>()));
                    break;
                case 2:
                    System.out.println("Insira a conta do email: ");
                    email = scanner.nextLine();
                    Customer menuCostumer = findCostumer(email, customersList);

                    if (menuCostumer == null) {
                        System.out.println("Email não cadastrado ou digitado incorretamente");
                        break;
                    }

                    while (true) {
                        System.out.println("""
                                ==========================
                                | 1 - Listar produtos    |
                                | 2 - Adicionar produto  |
                                | 3 - Remover produto    |
                                | 4 - Finalizar carrinho | 
                                | 5 - Sair da conta      |
                                ==========================
                                """);
                        opt = scanner.nextInt();
                        scanner.nextLine();

                        switch (opt) {
                            //lstar produtos
                            case 1:
                                for (Product product : productList) {
                                    System.out.println(product);
                                }
                                break;
                            //adicionar produto
                            case 2:
                                System.out.print("Insira o nome do produto: ");
                                String productName = scanner.nextLine();
                                Product product = findProduct(productName, productList);

                                if (product == null) {
                                    System.out.println("");
                                    break;
                                }


                                //TODO IMPLEMENTAR REGRA DE NEGÓCIO (ADICIONAR PRODUTO NA LISTA USANDO .SETAMOUNT E DEDUZINDO A QUANTIDADE DO ESTOQUE)
                                System.out.print("Insira o nome do produto: ");
                                int amount = scanner.nextInt();

                                break;
                            //remover produto
                            case 3:

                                break;
                            //verificar carrinho
                            case 4:
                                break;

                            case 5:
                                System.out.println("Retornando...");
                                return;

                        }
                    }


                case 3: //create product
                    System.out.println("Digite o nome do produto: ");
                    name = scanner.nextLine();
                    //Validar se esse produto já está cadastrado no sistema
                    System.out.println("Digite o preço do produto: ");
                    double price = scanner.nextDouble();
                    System.out.println("Digite a quantidade desse produto em estoque: ");
                    stock = scanner.nextInt();
                    productList.add(new Product(name, price, stock));
                    break;
                case 4: //delete product
                    System.out.println("Digite o nome do produto: ");
                    productList.removeIf(product -> product.getName().equals(scanner.nextLine()));
                    break;
                case 5:
                    System.out.println("Fechando loja...");
                    return;
            }
        }
    }

    public static Customer findCostumer(String email, List<Customer> customerList) {

        boolean costumerExist = false;
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(email)) {
                costumerExist = true;
                return customer;
            }
        }

        if (!costumerExist) {
            System.out.println("Conta não encontrada.");
        }

        return null;
    }

    public static Product findProduct(String productName, List<Product> productList) {

        boolean productExist = false;
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                productExist = true;
                return product;
            }
        }

        if (!productExist) {
            System.out.println("Produto não encontrado.");
        }

        return null;
    }
}

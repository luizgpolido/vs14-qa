import entities.Customer;
import entities.CustomerShoppingBag;
import entities.Product;
import entities.ProductEntry;
import services.ShoppingBagServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Customer> customersList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        ShoppingBagServices shoppingBagServices = new ShoppingBagServices();

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
                    System.out.print("Insira o nome do email: "); //Validar se já existe esse email cadastrado
                    email = scanner.nextLine();
                    customersList.add(new CustomerShoppingBag(name, email, new ArrayList<ProductEntry>()));
                    break;
                case 2:
                    System.out.println("Insira a conta do email: ");
                    email = scanner.nextLine();
                    Customer menuCostumer = findCostumer(email, customersList);
                    CustomerShoppingBag shoppingBagCustomer = (CustomerShoppingBag) menuCostumer;


                    if (menuCostumer == null) {
                        System.out.println("Email não cadastrado ou digitado incorretamente");
                        break;
                    }

                    while (true) {
                        System.out.println("""
                                ======================================
                                | 1 - Listar produtos                |
                                | 2 - Adicionar produto no carrinho  |
                                | 3 - Remover produto                |
                                | 4 - Finalizar carrinho             |
                                | 5 - Listar carrinho                |
                                | 6 - Sair da conta                  |
                                ======================================
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

                                System.out.print("Insira a quantidade: ");
                                int amount = scanner.nextInt();
                                scanner.nextLine();
                                ProductEntry productEntry = new ProductEntry(product, amount);
                                shoppingBagCustomer.addProduct(productEntry);

                                break;
                            //remover produto
                            case 3:
                                System.out.println("Informe o nome do produto: ");
                                shoppingBagCustomer.removeProduct(scanner.nextLine());
                                break;
                            //verificar carrinho
                            case 4:
                                shoppingBagServices = new ShoppingBagServices();
                                shoppingBagServices.generateCoupon(shoppingBagCustomer, menuCostumer);
                                break;

                            case 5:
                                shoppingBagServices = new ShoppingBagServices();
                                shoppingBagServices.listBag(shoppingBagCustomer, menuCostumer);
                                break;
                            case 6:

                                System.out.println("Retornando...");
                                break;

                        }
                    }


                case 3: //create product
                    System.out.println("Digite o nome do produto: ");
                    name = scanner.nextLine();
                    //Validar se esse produto já está cadastrado no sistema
                    System.out.println("Digite o preço do produto: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite a quantidade desse produto em estoque: ");
                    stock = scanner.nextInt();
                    scanner.nextLine();
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

// checagens gerais de variaveis (add e rm prod)
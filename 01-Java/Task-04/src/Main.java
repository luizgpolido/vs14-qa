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

        while (true) {
            System.out.println("""
                    =======================
                    | 1 - Create Account  |
                    | 2 - Access Account  | 
                    | 3 - Create Product  | 
                    | 4 - Delete Product  | 
                    | 5 - Exit Store      |
                    =======================
                    """);
            int opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    System.out.print("Insert the account name: ");
                    String name = scanner.nextLine();
                    System.out.print("Insert the account email: ");
                    String email = scanner.nextLine();
                    // Lista de Clientes instanciada com uma lista de produtos dentro dela, consultar CustomerShoppingBag para entender
                    // Usando upcasting da CustomerShoppingBag na Lista do tipo Customer
                    customersList.add(new CustomerShoppingBag(name, email, new ArrayList<Product>()));
                    break;
                case 2:
                    System.out.println("Insert the account email: ");
                    email = scanner.nextLine();
                    Customer menuCostumer = findCostumer(email, customersList);

                    if (menuCostumer == null) {
                        break;
                    }

                    while (true) {
                        System.out.println("""
                                =======================
                                | 1 - List products   |
                                | 2 - Add product     |
                                | 3 - Remove product  |
                                | 4 - Check the bag   | 
                                | 5 - Exit Account    |
                                =======================
                                """);
                            opt = scanner.nextInt();
                            scanner.nextLine();

                            switch (opt){
                                case 1:
                                    for (Product product : productList){
                                        System.out.println(product);
                                    }
                                    break;
                                case 2:
                                    System.out.print("Insert the name of the product: ");
                                    String productName = scanner.nextLine();
                                    Product product = findProduct(productName, productList);

                                    if (product == null) {
                                        break;
                                    }

                                    //TODO IMPLEMENTAR REGRA DE NEGÓCIO (ADICIONAR PRODUTO NA LISTA USANDO .SETAMOUNT E DEDUZINDO A QUANTIDADE DO ESTOQUE)
                                    System.out.println("Insert the amount: ");
                                    int amount = scanner.nextInt();

                                    break;
                                case 3:

                                    break;
                            }
                    }

                    break;
                case 3:
                    System.out.println("Closing store...");
                    break;
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
            System.out.println("Account not found.");
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
            System.out.println("Product not found.");
        }

        return null;
    }
}

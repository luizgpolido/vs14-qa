package services;

import entities.Customer;
import entities.CustomerShoppingBag;
import entities.ProductEntry;

import java.util.List;

public class ShoppingBagServices {

    //TODO IMPLEMENTAR CLASSE, CRIAR REGRAS DE NEGÓCIO NO CALCULO DA SACOLA (MÉTODO COMPLEXO, POR ISSO SEPAREI EM OUTRA CLASSE!)

    public double calculateShoppingBag(List<ProductEntry> shoppingBag) {
       double   total = 0;
        for (int i = 0; i < shoppingBag.size(); i++) {
            total += shoppingBag.get(i).getProduct().getPrice()*shoppingBag.get(i).getProduct().getStock();
        }
        System.out.println("Total: " + total);
        return total;
    }

    public void generateCoupon(CustomerShoppingBag customerShoppingBag, Customer customer) {
        List<ProductEntry> shoppingBag = customerShoppingBag.getShoppingBagList();
        System.out.println("========== Recibo ==========");
        System.out.println("Cliente: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Produtos:");
        for (int i = 0; i < shoppingBag.size(); i++) {
            System.out.println("- " + shoppingBag.get(i).getProduct().getName() +
                    " | Quantidade: " + shoppingBag.get(i).getProduct().getStock() + " | Preço unitário: R$" +
                    shoppingBag.get(i).getProduct().getPrice());
        }
        double total = calculateShoppingBag(shoppingBag);
        System.out.println("Total: R$" + total);
        System.out.println("============================");
    }
}
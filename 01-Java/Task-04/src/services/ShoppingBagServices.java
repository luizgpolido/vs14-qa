package services;

import java.util.List;

public class ShoppingBagServices {

    //TODO IMPLEMENTAR CLASSE, CRIAR REGRAS DE NEGÓCIO NO CALCULO DA SACOLA (MÉTODO COMPLEXO, POR ISSO SEPAREI EM OUTRA CLASSE!)

    // calcular carrinho
    public void calculateShoppingBag(List<Product> shoppingBagList) {
       double   total = 0;
        for (Product product : shoppingBagList) {
            total += product.getPrice()*product.getStock();
        }
        System.out.println("Total: " + total);
    }

    public void generateCoupon(CustomerShoppingBag shoppingBag) {
        System.out.println("========== Recibo ==========");
        System.out.println("Cliente: " + shoppingBag.getName());
        System.out.println("Email: " + shoppingBag.getEmail());
        System.out.println("Produtos:");
        for (Product product : shoppingBag.getShoppingBagList()) {
            System.out.println("- " + product.getName() + " | Quantidade: " + product.getQuantity() + " | Preço unitário: R$" + product.getPrice());
        }
        double total = calcularTotal(shoppingBag.getShoppingBagList());
        System.out.println("Total: R$" + total);
        System.out.println("============================");
    }

}

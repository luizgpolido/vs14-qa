package entities;

import java.util.List;


public class CustomerShoppingBag extends Customer {

    // {Product, int amount}
    private List<ProductEntry> shoppingBagList;

    public CustomerShoppingBag(String name, String email, List<ProductEntry> shoppingBagList) {
        super(name, email);
        this.shoppingBagList = shoppingBagList;
    }

    public List<ProductEntry> getShoppingBagList() {
        return shoppingBagList;
    }


    //TODO não pode pegar mais do q tem em estoque
    public void addProduct(ProductEntry productEntry) {
        if (productEntry.getProduct().getStock() < productEntry.getAmount()) {
            System.out.println("Quantidade pedida maior que nosso estoque!");
            return;
        } else if (productEntry.getAmount() < 0) {
            System.out.println("Por favor, digite um número positivo.");
            return;
        }
        shoppingBagList.add(productEntry);
        Product produto = productEntry.getProduct();
        produto.setStock(produto.getStock() - productEntry.getAmount());
    }

    // TODO remover a quantidade pedida
    // TODO se quantidade for zero, remover produto da bag
    public void removeProduct(String productName, int amountToRemove) {
        for (ProductEntry productEntry : shoppingBagList) {
            Product product = productEntry.getProduct();
            int amount = productEntry.getAmount();
            if (product.getName().equals(productName)) {
                // se é maior que o disponivel na sacola remove a quantidade pedida
                if ((amount - amountToRemove) <= 0) {
                    shoppingBagList.removeIf(i -> i.getProduct().getName().equals(productName));
                }  else { // se é menor que o disponivel na sacola remove a o produto
                    product.addStock(amountToRemove);
                    productEntry.setAmount(amount - amountToRemove);
                }


            }
        }
    }
}
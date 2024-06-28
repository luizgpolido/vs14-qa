package entities;

import java.util.List;


public class CustomerShoppingBag extends Customer {

    // {Product, amount(Integer)}
    private List<ProductEntry> shoppingBagList;

    public CustomerShoppingBag(String name, String email, List<ProductEntry> shoppingBagList) {
        super(name, email);
        this.shoppingBagList = shoppingBagList;
    }

    public List<ProductEntry> getShoppingBagList() {
        return shoppingBagList;
    }

    public void addProduct(ProductEntry productEntry) {
        shoppingBagList.add(productEntry);
        Product produto = productEntry.getProduct();
        produto.setStock(produto.getStock() - productEntry.getAmount());
    }

    // remove product
    //não pode pegar mais do q tem em estoque
    public void removeProduct(String productName) {
        for (ProductEntry productEntry : shoppingBagList) {
            if (productEntry.getProduct().getName().equals(productName)) {
                Product product = productEntry.getProduct();
                int amount = productEntry.getAmount();
                product.addStock(amount);
            }
        }
        shoppingBagList.removeIf(productEntry -> productEntry.getProduct().getName().equals(productName));
    }
}

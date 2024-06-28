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

    //TODO IMPLEMENTAR REGRA DE NEGOCIO CITADA NA MAIN
    public void addProduct(ProductEntry productWithAmount) {
        shoppingBagList.add(productWithAmount);
    }

    // remove product
    //não pode pegar mais do q tem em estoque
}

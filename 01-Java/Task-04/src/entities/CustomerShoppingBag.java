package entities;

import java.util.ArrayList;
import java.util.List;

public class CustomerShoppingBag extends Customer {

    private List<Product> shoppingBagList;

    public CustomerShoppingBag(String name, String email, List<Product> shoppingBagList) {
        super(name, email);
        this.shoppingBagList = shoppingBagList;
    }

    public List<Product> getShoppingBagList() {
        return shoppingBagList;
    }

    //TODO IMPLEMENTAR REGRA DE NEGOCIO CITADA NA MAIN
    public void addProduct(Product product){
        shoppingBagList.add(product);
    }

}

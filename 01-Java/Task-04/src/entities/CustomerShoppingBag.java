package entities;

import java.util.ArrayList;
import java.util.List;

public class CustomerShoppingBag extends Customer {

    // {Product, amount(Integer)}
    private List<List<Object>> shoppingBagList;

    public CustomerShoppingBag(String name, String email, List<List<Object>> shoppingBagList) {
        super(name, email);
        this.shoppingBagList = shoppingBagList;
    }

    public List<List<Object>> getShoppingBagList() {
        return shoppingBagList;
    }

    //TODO IMPLEMENTAR REGRA DE NEGOCIO CITADA NA MAIN
    public void addProduct(List<Object> productWithAmount) {
        shoppingBagList.add(productWithAmount);
    }

    // remove product
    //não pode pegar mais do q tem em estoque
}

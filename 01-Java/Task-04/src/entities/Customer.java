package entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String email;
    private CustomerShoppingBag shoppingBag;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.shoppingBag = new CustomerShoppingBag(name, email, new ArrayList<List<Object>>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

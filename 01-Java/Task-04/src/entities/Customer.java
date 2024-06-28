package entities;



public class Customer {

    private String name;
    private String email;
    private CustomerShoppingBag shoppingBag;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
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

    public CustomerShoppingBag getShoppingBag() {
        return shoppingBag;
    }

}

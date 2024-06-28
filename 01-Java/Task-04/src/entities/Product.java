package entities;

import java.util.List;

public class Product {


    private String name;
    private double price;
    private int stock;


    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addStock(int add) {this.stock += add;}

    @Override
    public String toString() {
        return String.format("\nProduct: %s\nPrice: %.2f\nStock: %d", name, price, stock);
    }

}

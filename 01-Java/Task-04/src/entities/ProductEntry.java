package entities;

public class ProductEntry {
    private Product product;
    private int amount;

    public ProductEntry(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    // Getters e setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

import java.util.Objects;

public class Product implements Comparable<Product> {

    private String sku;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(String sku, String name, String category,
                   double price, int quantity) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Natural sorting by SKU
    @Override
    public int compareTo(Product other) {
        return this.sku.compareTo(other.sku);
    }

    public double getValue() {
        return price * quantity;
    }

    // Getters & Setters
    public String getSku() { return sku; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return sku.equals(product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-15s ₹%-10.2f %-8d ₹%-10.2f",
                sku, name, category, price, quantity, getValue());
    }
}

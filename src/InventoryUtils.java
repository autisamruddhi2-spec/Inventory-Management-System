import java.util.*;

public class InventoryUtils {

    public static Product findBySku(Set<Product> set, String sku) {
        for (Product p : set) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }
        return null;
    }

    public static double calculateTotalValue(Collection<Product> products) {
        double total = 0;
        for (Product p : products) {
            total += p.getValue();
        }
        return total;
    }
}

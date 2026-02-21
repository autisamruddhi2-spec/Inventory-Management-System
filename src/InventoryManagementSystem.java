import java.util.*;

public class InventoryManagementSystem {

    private HashSet<Product> productSet = new HashSet<>();
    private LinkedList<Transaction> transactions = new LinkedList<>();
    private Stack<Runnable> undoStack = new Stack<>();
    private Queue<Product> lowStockQueue = new LinkedList<>();

    private static final int LOW_STOCK_LIMIT = 10;

    public void addProduct(Product product) {

        if (productSet.add(product)) {

            transactions.addFirst(
                    new Transaction("ADD",
                            product.getSku() + " - " + product.getName())
            );

            undoStack.push(() -> {
                productSet.remove(product);
                transactions.removeFirst();
                lowStockQueue.remove(product);
            });

            if (product.getQuantity() < LOW_STOCK_LIMIT &&
                    !lowStockQueue.contains(product)) {
                lowStockQueue.offer(product);
            }

            System.out.println("✅ Product added successfully!");
        } else {
            System.out.println("❌ Product already exists!");
        }
    }

    public void updateQuantity(String sku, int newQty) {

        Product product = InventoryUtils.findBySku(productSet, sku);

        if (product != null) {

            int oldQty = product.getQuantity();
            product.setQuantity(newQty);

            transactions.addFirst(
                    new Transaction("UPDATE",
                            sku + " from " + oldQty + " to " + newQty)
            );

            undoStack.push(() -> {
                product.setQuantity(oldQty);
                transactions.removeFirst();
            });

            if (newQty < LOW_STOCK_LIMIT &&
                    !lowStockQueue.contains(product)) {
                lowStockQueue.offer(product);
            }

            System.out.println("✅ Quantity updated!");
        } else {
            System.out.println("❌ Product not found!");
        }
    }

    public void viewSorted(String criteria) {

        List<Product> list = new ArrayList<>(productSet);

        switch (criteria.toLowerCase()) {
            case "price":
                list.sort(new PriceComparator());
                break;
            case "name":
                list.sort((Comparator<? super Product>) new NameComparator());
                break;
            case "value":
                list.sort(new ValueComparator());
                break;
            default:
                Collections.sort(list);
        }

        list.forEach(System.out::println);
    }

    public void showLowStock() {
        System.out.println("=== LOW STOCK ITEMS ===");
        for (Product p : lowStockQueue) {
            System.out.println(p.getSku() + " - Qty: " + p.getQuantity());
        }
    }

    public void showTransactions(int count) {
        int i = 0;
        for (Transaction t : transactions) {
            if (i++ == count) break;
            System.out.println(t);
        }
    }

    public void showStatistics() {
        System.out.println("Total Products: " + productSet.size());
        System.out.println("Total Value: ₹" +
                InventoryUtils.calculateTotalValue(productSet));
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            undoStack.pop().run();
            System.out.println("✅ Last action undone!");
        } else {
            System.out.println("⚠ Nothing to undo!");
        }
    }
}

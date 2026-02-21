import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== INVENTORY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Quantity");
            System.out.println("3. View Products (Sorted)");
            System.out.println("4. Low Stock Alerts");
            System.out.println("5. Transaction History");
            System.out.println("6. Inventory Statistics");
            System.out.println("7. Undo Last Update");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("SKU: ");
                    String sku = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Category: ");
                    String cat = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    ims.addProduct(new Product(sku, name, cat, price, qty));
                    break;

                case 2:
                    System.out.print("Enter SKU: ");
                    String updateSku = sc.nextLine();
                    System.out.print("New Quantity: ");
                    int newQty = sc.nextInt();
                    sc.nextLine();
                    ims.updateQuantity(updateSku, newQty);
                    break;

                case 3:
                    System.out.print("Sort by (sku/price/value/name): ");
                    String sort = sc.nextLine();
                    ims.viewSorted(sort);
                    break;

                case 4:
                    ims.showLowStock();
                    break;

                case 5:
                    System.out.print("How many transactions? ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    ims.showTransactions(n);
                    break;

                case 6:
                    ims.showStatistics();
                    break;

                case 7:
                    ims.undo();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

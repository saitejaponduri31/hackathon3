import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PharmaSupplyChainSystem {

    static class Product {
        int id;
        String name;
        String manufacturer;
        String currentOwner;
        boolean isValid;

        Product(int id, String name, String manufacturer, String currentOwner, boolean isValid) {
            this.id = id;
            this.name = name;
            this.manufacturer = manufacturer;
            this.currentOwner = currentOwner;
            this.isValid = isValid;
        }
    }

    private static final Map<Integer, Product> products = new HashMap<>();
    private static int productCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Transfer Ownership");
            System.out.println("3. View Product");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter current owner: ");
                    String currentOwner = scanner.nextLine();
                    addProduct(name, manufacturer, currentOwner);
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new owner: ");
                    String newOwner = scanner.nextLine();
                    transferOwnership(id, newOwner);
                    break;
                case 3:
                    System.out.print("Enter product ID: ");
                    id = scanner.nextInt();
                    viewProduct(id);
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addProduct(String name, String manufacturer, String currentOwner) {
        productCount++;
        products.put(productCount, new Product(productCount, name, manufacturer, currentOwner, true));
        System.out.println("Product added successfully. ID: " + productCount);
    }

    private static void transferOwnership(int id, String newOwner) {
        Product product = products.get(id);
        if (product != null && product.isValid) {
            product.currentOwner = newOwner;
            System.out.println("Ownership transferred to: " + newOwner);
        } else {
            System.out.println("Product not found or invalid.");
        }
    }

    private static void viewProduct(int id) {
        Product product = products.get(id);
        if (product != null && product.isValid) {
            System.out.println("ID: " + product.id);
            System.out.println("Name: " + product.name);
            System.out.println("Manufacturer: " + product.manufacturer);
            System.out.println("Current Owner: " + product.currentOwner);
        } else {
            System.out.println("Product not found or invalid.");
        }
    }
}

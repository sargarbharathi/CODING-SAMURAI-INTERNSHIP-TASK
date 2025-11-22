import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class ECommerceSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample products
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 45000));
        products.add(new Product(2, "Headphones", 1500));
        products.add(new Product(3, "Smartphone", 20000));
        products.add(new Product(4, "Keyboard", 600));

        ArrayList<Product> cart = new ArrayList<>();

        System.out.println("===== Welcome to Java E-Commerce System =====");
        System.out.print("Enter your username: ");
        String user = sc.nextLine();

        System.out.println("Hello, " + user + "!");

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Available Products ---");
                    for (Product p : products) {
                        System.out.println(p.id + ". " + p.name + " - ₹" + p.price);
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to Add: ");
                    int id = sc.nextInt();

                    boolean found = false;
                    for (Product p : products) {
                        if (p.id == id) {
                            cart.add(p);
                            System.out.println(p.name + " added to cart!");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid Product ID!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Your Cart ---");
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        double total = 0;
                        for (Product p : cart) {
                            System.out.println(p.name + " - ₹" + p.price);
                            total += p.price;
                        }
                        System.out.println("Total Amount: ₹" + total);
                    }
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty! Add products first.");
                    } else {
                        double total = 0;
                        for (Product p : cart) {
                            total += p.price;
                        }
                        System.out.println("\nCheckout Successful!");
                        System.out.println("Total Amount Paid: ₹" + total);
                        cart.clear();
                    }
                    break;

                case 5:
                    System.out.println("Thanks for shopping, " + user + "!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


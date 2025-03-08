import Controller.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View All Products");
            System.out.println("2. Update Product Name");
            System.out.println("3. Update Product Price");
            System.out.println("4. Update Product Quantity");
            System.out.println("5. Exit");
            System.out.print("=> Enter your choice: ");

            int choice = 0;
            boolean choiceChecker = false;

            while (!choiceChecker) {
                try {
                    choice = scanner.nextInt();
                    choiceChecker = true;
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a valid integer choice.");
                    scanner.nextLine();
                    System.out.print("=> Enter your choice: ");
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("\nList of products :");
                    controller.displayAllProducts();
                    break;
                case 2:
                    System.out.println("\nList of products :");
                    controller.displayAllProducts();
                    controller.updateProductName();
                    System.out.println("\nUpdated list of products :");
                    controller.displayAllProducts();
                    break;
                case 3:
                    System.out.println("\nList of products :");
                    controller.displayAllProducts();
                    controller.updateProductPrice();
                    System.out.println("\nUpdated list of products :");
                    controller.displayAllProducts();
                    break;
                case 4:
                    System.out.println("\nList of products :");
                    controller.displayAllProducts();
                    controller.updateProductQuantity();
                    System.out.println("\nUpdated list of products :");
                    controller.displayAllProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

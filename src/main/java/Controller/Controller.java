package Controller;

import Model.Product;
import DAO.DAO;
import View.View;

import java.util.Scanner;

public class Controller {
    private final DAO productDAO;
    private final View productView;
    private final Scanner scanner;

    //booleans for validating input values
    private boolean checkName = false;
    private boolean checkPrice = false;
    private boolean checkQuantity = false;

    public Controller() {
        this.productDAO = new DAO();
        this.productView = new View();
        this.scanner = new Scanner(System.in);
    }

    public void displayAllProducts() {
        productView.displayAllProducts(productDAO.getAllProducts());
    }


    public void updateProductName() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = productDAO.getProductById(id);
        productView.displayProduct(product);

        if (product != null) {
            checkName = false;
            // invalid input loop
            while(!checkName) {
                System.out.print("Enter New Name: ");
                String newName = scanner.nextLine();
                //validate name input
                if (verifyName(newName)) {
                    //stop the invalid input loop
                    checkName = true;
                    boolean success = productDAO.updateProductName(id, newName);
                    productView.showUpdateSuccess(success);
                } else {
                    System.out.println("Invalid name input.");
                }
            }
        }
    }

    public void updateProductPrice() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = productDAO.getProductById(id);
        productView.displayProduct(product);

        if (product != null) {
            checkPrice = false;
            while(!checkPrice) {
                System.out.print("Enter New Price: ");
                String newPrice = scanner.nextLine();
                if (verifyDouble(newPrice)) {
                    checkPrice = true;
                    boolean success = productDAO.updateProductPrice(id, Double.parseDouble(newPrice));
                    productView.showUpdateSuccess(success);
                } else {
                    System.out.println("Invalid price input.");
                }
            }
        }
    }

    public void updateProductQuantity() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = productDAO.getProductById(id);
        productView.displayProduct(product);

        if (product != null) {
            checkQuantity = false;
            while(!checkQuantity) {
                System.out.print("Enter New Quantity: ");
                String newQuantity = scanner.nextLine();
                if(verifyInteger(newQuantity)) {
                    checkQuantity = true;
                    boolean success = productDAO.updateProductQuantity(id, Integer.parseInt(newQuantity));
                    productView.showUpdateSuccess(success);
                } else {
                    System.out.println("Invalid quantity input.");
                }
            }
        }
    }

    //verify double
    public static boolean verifyDouble(String input) {
        try{
            Double.parseDouble(input);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    //verify int
    private static boolean verifyInteger(String input) {
        try{
            Integer.parseInt(input);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    //verify name
    public static boolean verifyName(String name) {
        String regex = "^[\\p{L} .'-]+$";
        return name != null && name.matches(regex);
    }
}
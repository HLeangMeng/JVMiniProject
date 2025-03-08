package View;

import Model.Product;
import java.util.List;

public class View {
    public void displayProduct(Product product) {
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayAllProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void showUpdateSuccess(boolean success) {
        if (success) {
            System.out.println("Update successful!");
        } else {
            System.out.println("Update failed.");
        }
    }
}


package Model;

public class Product {
    private int id, quantity;
    private String name, importedDate;
    private double unitPrice;

    public Product(int id, String name, double unitPrice, int quantity, String importedDate) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.importedDate = importedDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getImportedDate() { return importedDate; }
    public void setImportedDate(String importedDate) { this.importedDate = importedDate; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + unitPrice +
                ", Quantity: " + quantity + ", Imported Date: " + importedDate;
    }
}

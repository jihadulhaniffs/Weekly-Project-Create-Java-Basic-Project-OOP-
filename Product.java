public class Product {
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        if (stock < 0) {
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

    public boolean addStock(int quantity) {
        if (quantity <= 0) {
            return false;
        } else {
            this.stock += quantity;
            return true;
        }
    }

    public boolean reduceStock(int quantity) {
        if (quantity <= 0) {
            return false;
        } else if (quantity > this.stock) {
            return false;
        } else {
            this.stock -= quantity;
            return true;
        }
    }
}

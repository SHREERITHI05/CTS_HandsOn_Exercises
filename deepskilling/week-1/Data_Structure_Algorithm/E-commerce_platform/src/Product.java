/**
 * Product - Represents an e-commerce product entity.
 * Implements Comparable to support sorting for Binary Search.
 */
public class Product implements Comparable<Product> {

    private int    productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId   = productId;
        this.productName = productName;
        this.category    = category;
    }

    // Getters
    public int    getProductId()   { return productId;   }
    public String getProductName() { return productName; }
    public String getCategory()    { return category;    }

    // Natural ordering by productId — required for Binary Search
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return String.format("Product{id=%-4d | name=%-25s | category=%s}",
                productId, productName, category);
    }
}
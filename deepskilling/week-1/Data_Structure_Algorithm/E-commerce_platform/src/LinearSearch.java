/**
 * LinearSearch - O(n) sequential search through unsorted array.
 *
 * Best Case  : O(1) — target is the first element
 * Average Case: O(n/2) → O(n) — target is in the middle
 * Worst Case : O(n) — target is last or not found
 */
public class LinearSearch {

    /**
     * Search by productId — scans every element until match found.
     */
    public static Product searchById(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                System.out.println("  [Linear] Found at index " + i +
                        " after " + (i + 1) + " comparison(s)");
                return products[i];
            }
        }
        System.out.println("  [Linear] Product not found after " +
                products.length + " comparison(s)");
        return null;
    }

    /**
     * Search by productName — case-insensitive match.
     */
    public static Product searchByName(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                System.out.println("  [Linear] Found at index " + i +
                        " after " + (i + 1) + " comparison(s)");
                return products[i];
            }
        }
        System.out.println("  [Linear] Product not found after " +
                products.length + " comparison(s)");
        return null;
    }
}
/**
 * BinarySearch - O(log n) divide-and-conquer on SORTED array.
 *
 * Best Case  : O(1) — target is the middle element
 * Average Case: O(log n) — halves the search space each step
 * Worst Case : O(log n) — target is at the boundary or not found
 *
 * REQUIREMENT: Array must be sorted by productId before searching.
 */
public class BinarySearch {

    /**
     * Iterative binary search by productId.
     * Tracks comparisons made to demonstrate efficiency vs linear search.
     */
    public static Product searchById(Product[] products, int targetId) {
        int low         = 0;
        int high        = products.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids integer overflow
            comparisons++;

            if (products[mid].getProductId() == targetId) {
                System.out.println("  [Binary] Found at index " + mid +
                        " after " + comparisons + " comparison(s)");
                return products[mid];
            } else if (products[mid].getProductId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("  [Binary] Product not found after " +
                comparisons + " comparison(s)");
        return null;
    }
}
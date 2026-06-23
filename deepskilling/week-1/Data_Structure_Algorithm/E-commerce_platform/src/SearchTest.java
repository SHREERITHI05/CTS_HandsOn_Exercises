import java.util.Arrays;

/**
 * SearchTest — Demonstrates and compares Linear vs Binary Search.
 *
 * Also covers:
 *  - Big O notation explanation
 *  - Best / Average / Worst case analysis
 *  - Performance comparison with timing
 */
public class SearchTest {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("   E-Commerce Platform — Search Optimization ");
        System.out.println("==============================================\n");

        // ── Big O Explanation ──────────────────────────────────────────
        System.out.println("📘 BIG O NOTATION OVERVIEW");
        System.out.println("------------------------------------------");
        System.out.println("  Big O describes how runtime grows with input size (n).");
        System.out.println("  O(1)     → Constant  : doesn't grow with n");
        System.out.println("  O(log n) → Logarithmic: doubles input → +1 step (Binary Search)");
        System.out.println("  O(n)     → Linear    : doubles input → doubles steps (Linear Search)");
        System.out.println("  O(n²)    → Quadratic : doubles input → 4x steps (Bubble Sort)\n");

        System.out.println("  CASE ANALYSIS FOR SEARCH:");
        System.out.println("  ┌────────────────┬────────────┬─────────────┐");
        System.out.println("  │ Case           │ Linear     │ Binary      │");
        System.out.println("  ├────────────────┼────────────┼─────────────┤");
        System.out.println("  │ Best Case      │ O(1)       │ O(1)        │");
        System.out.println("  │ Average Case   │ O(n)       │ O(log n)    │");
        System.out.println("  │ Worst Case     │ O(n)       │ O(log n)    │");
        System.out.println("  │ Requires Sort? │ No         │ Yes         │");
        System.out.println("  └────────────────┴────────────┴─────────────┘\n");

        // ── Product Dataset ────────────────────────────────────────────
        Product[] products = {
            new Product(101, "Samsung Galaxy S24",    "Electronics"),
            new Product(205, "Nike Air Max 270",      "Footwear"),
            new Product(340, "Sony WH-1000XM5",       "Electronics"),
            new Product(412, "Levi's 501 Jeans",      "Clothing"),
            new Product(530, "Apple MacBook Air M2",  "Electronics"),
            new Product(618, "Whirlpool Microwave",   "Appliances"),
            new Product(724, "Kindle Paperwhite",     "Books & Media"),
            new Product(815, "Adidas Ultraboost 22",  "Footwear"),
            new Product(903, "Canon EOS R50 Camera",  "Electronics"),
            new Product(999, "IKEA KALLAX Shelf",     "Furniture")
        };

        // Sorted copy for Binary Search
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts);

        // ── Test 1: Search existing product ───────────────────────────
        System.out.println("── Test 1: Search by ID = 530 (Apple MacBook Air M2) ──");

        System.out.println("\n  → Linear Search:");
        long start = System.nanoTime();
        Product r1 = LinearSearch.searchById(products, 530);
        long linearTime = System.nanoTime() - start;
        if (r1 != null) System.out.println("  Result : " + r1);
        System.out.println("  Time   : " + linearTime + " ns");

        System.out.println("\n  → Binary Search:");
        start = System.nanoTime();
        Product r2 = BinarySearch.searchById(sortedProducts, 530);
        long binaryTime = System.nanoTime() - start;
        if (r2 != null) System.out.println("  Result : " + r2);
        System.out.println("  Time   : " + binaryTime + " ns");

        // ── Test 2: Search last element (worst case for linear) ────────
        System.out.println("\n── Test 2: Worst Case — ID = 999 (last element) ──");

        System.out.println("\n  → Linear Search:");
        Product r3 = LinearSearch.searchById(products, 999);
        if (r3 != null) System.out.println("  Result : " + r3);

        System.out.println("\n  → Binary Search:");
        Product r4 = BinarySearch.searchById(sortedProducts, 999);
        if (r4 != null) System.out.println("  Result : " + r4);

        // ── Test 3: Search by name ─────────────────────────────────────
        System.out.println("\n── Test 3: Search by Name = 'Kindle Paperwhite' ──");
        System.out.println("\n  → Linear Search (only method that supports name search):");
        Product r5 = LinearSearch.searchByName(products, "Kindle Paperwhite");
        if (r5 != null) System.out.println("  Result : " + r5);

        // ── Test 4: Product not found ──────────────────────────────────
        System.out.println("\n── Test 4: ID = 777 (not in catalog) ──");

        System.out.println("\n  → Linear Search:");
        LinearSearch.searchById(products, 777);

        System.out.println("\n  → Binary Search:");
        BinarySearch.searchById(sortedProducts, 777);

        // ── Final Analysis ─────────────────────────────────────────────
        System.out.println("\n==============================================");
        System.out.println("  ANALYSIS & RECOMMENDATION");
        System.out.println("==============================================");
        System.out.println("  Linear Search : Simple, works on unsorted data,");
        System.out.println("                  supports name/category search.");
        System.out.println("                  Suitable for small catalogs < 100 items.\n");
        System.out.println("  Binary Search : Significantly faster at scale.");
        System.out.println("                  1M products → max 20 comparisons (log₂ 1M ≈ 20).");
        System.out.println("                  Ideal for large, ID-indexed product catalogs.\n");
        System.out.println("  VERDICT       : Use Binary Search for productId lookups.");
        System.out.println("                  Use Linear Search for name/category filters");
        System.out.println("                  or pair with indexing (HashMap) for O(1) lookup.");
        System.out.println("==============================================");
    }
}
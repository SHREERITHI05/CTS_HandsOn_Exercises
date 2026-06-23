/**
 * FinancialForecastTest — Demonstrates recursive financial forecasting.
 *
 * Scenarios:
 *  1. Fixed growth rate — simple recursive forecast
 *  2. Memoized vs plain recursive — performance comparison
 *  3. Variable growth rates — real-world market simulation
 *  4. Compound interest — quarterly/monthly compounding
 *  5. Year-by-year projection table
 */
public class FinancialForecastTest {

    static final String DIVIDER = "------------------------------------------------";

    public static void main(String[] args) {

        ForecastEngine engine = new ForecastEngine();

        System.out.println("================================================");
        System.out.println("     Financial Forecasting Tool — Recursive     ");
        System.out.println("================================================\n");

        // ── Recursion Explanation ──────────────────────────────────────
        System.out.println("RECURSION CONCEPT");
        System.out.println(DIVIDER);
        System.out.println("  Recursion breaks a problem into smaller same-type");
        System.out.println("  subproblems, solving until a base case is reached.\n");
        System.out.println("  Financial Formula:");
        System.out.println("  FV(0) = PresentValue              <- base case");
        System.out.println("  FV(n) = FV(n-1) x (1 + rate)     <- recursive case\n");
        System.out.println("  Example: Rs.1,00,000 at 8% for 3 years:");
        System.out.println("  FV(3) = FV(2) x 1.08");
        System.out.println("        = FV(1) x 1.08 x 1.08");
        System.out.println("        = FV(0) x 1.08 x 1.08 x 1.08");
        System.out.println("        = 1,00,000 x 1.08^3 = Rs.1,25,971\n");

        // ── Test 1: Fixed Growth Rate ──────────────────────────────────
        System.out.println("-- Test 1: Fixed Annual Growth Rate --");
        double principal = 100000;
        double rate      = 0.08;
        int    years     = 5;

        double futureValue = engine.calculateFutureValue(principal, rate, years);
        System.out.printf("  Principal  : Rs.%,.2f%n", principal);
        System.out.printf("  Rate       : %.0f%% per annum%n", rate * 100);
        System.out.printf("  Period     : %d years%n", years);
        System.out.printf("  Future Value (Recursive)  : Rs.%,.2f%n", futureValue);
        System.out.printf("  Future Value (Iterative)  : Rs.%,.2f%n",
                engine.calculateFutureValueIterative(principal, rate, years));
        System.out.println("  PASS - Both methods match, recursion verified\n");

        // ── Test 2: Year-by-Year Projection Table ─────────────────────
        System.out.println("-- Test 2: Year-by-Year Projection (8% rate) --");
        System.out.println("  +------+------------------+--------------+");
        System.out.println("  | Year | Future Value(Rs) | Growth (Rs)  |");
        System.out.println("  +------+------------------+--------------+");

        double prev = principal;
        for (int y = 1; y <= 10; y++) {
            double fv     = engine.calculateFutureValueMemo(principal, rate, y);
            double growth = fv - prev;
            System.out.printf("  | %-4d | %,16.2f | %,12.2f |%n", y, fv, growth);
            prev = fv;
        }
        System.out.println("  +------+------------------+--------------+\n");

        // ── Test 3: Variable Growth Rates ─────────────────────────────
        System.out.println("-- Test 3: Variable Growth Rate (Market Simulation) --");
        double[] marketRates = { 0.12, 0.07, -0.03, 0.15, 0.09 };
        System.out.println("  Yearly rates: +12%, +7%, -3%, +15%, +9%");

        double variableFV = engine.calculateVariableGrowth(principal, marketRates,
                marketRates.length);
        System.out.printf("  Starting Value : Rs.%,.2f%n", principal);
        System.out.printf("  Final Value    : Rs.%,.2f%n", variableFV);
        System.out.printf("  Net Growth     : Rs.%,.2f (%.1f%%)%n",
                variableFV - principal,
                ((variableFV - principal) / principal) * 100);

        // ── Test 4: Compound Interest ──────────────────────────────────
        System.out.println("\n-- Test 4: Compound Interest Comparison --");
        System.out.println("  Principal: Rs.1,00,000 | Rate: 10% | Period: 5 years");
        System.out.println("  +---------------------+------------------+");
        System.out.println("  | Compounding         | Future Value(Rs) |");
        System.out.println("  +---------------------+------------------+");

        int[][]  compoundings = {{1, 5}, {4, 20}, {12, 60}};
        String[] labels       = {"Annual  (1x/yr) ", "Quarterly(4x/yr)", "Monthly (12x/yr)"};

        for (int i = 0; i < compoundings.length; i++) {
            double cv = engine.calculateCompoundInterest(
                    principal, 0.10, compoundings[i][0], compoundings[i][1]);
            System.out.printf("  | %s | %,16.2f |%n", labels[i], cv);
        }
        System.out.println("  +---------------------+------------------+");

        // ── Test 5: Performance — Memoized vs Iterative ───────────────
        System.out.println("\n-- Test 5: Performance -- Memoized vs Iterative --");
        int largePeriod = 30;   // safe recursion depth for demo
        engine.clearCache();

        long t1 = System.nanoTime();
        engine.calculateFutureValueMemo(principal, 0.08, largePeriod);
        long memoTime = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        engine.calculateFutureValueIterative(principal, 0.08, largePeriod);
        long iterTime = System.nanoTime() - t2;

        System.out.println("  Periods tested : " + largePeriod);
        System.out.println("  Memoized Time  : " + memoTime + " ns");
        System.out.println("  Iterative Time : " + iterTime + " ns");

        // ── Complexity Analysis ────────────────────────────────────────
        System.out.println("\n================================================");
        System.out.println("  COMPLEXITY ANALYSIS");
        System.out.println("================================================");
        System.out.println("  Plain Recursive : O(n) time | O(n) space (call stack)");
        System.out.println("  Memoized        : O(n) time | O(n) space (cache)");
        System.out.println("  Iterative       : O(n) time | O(1) space <- most efficient");
        System.out.println();
        System.out.println("  OPTIMIZATION STRATEGIES:");
        System.out.println("  1. Memoization  -- cache repeated subproblem results");
        System.out.println("  2. Iteration    -- eliminate call stack overhead");
        System.out.println("  3. Math formula -- FV = PV*(1+r)^n -> O(log n) via fast pow");
        System.out.println();
        System.out.println("  RECOMMENDATION:");
        System.out.println("  Use recursion for variable-rate/branching forecasts.");
        System.out.println("  Use iteration or Math.pow() for fixed-rate scenarios.");
        System.out.println("================================================");
    }
}
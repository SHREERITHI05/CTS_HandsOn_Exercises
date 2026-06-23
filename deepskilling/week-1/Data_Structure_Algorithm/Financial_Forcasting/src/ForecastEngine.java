import java.util.HashMap;
import java.util.Map;

/**
 * ForecastEngine - Recursive Financial Forecasting with Memoization.
 *
 * FutureValue(n) = FutureValue(n-1) x (1 + growthRate)
 * Base case: FutureValue(0) = initialValue
 *
 * TIME COMPLEXITY:
 *   Plain Recursive : O(n) time | O(n) space (call stack)
 *   Memoized        : O(n) time | O(n) space (cache)
 *   Iterative       : O(n) time | O(1) space  <- best
 */
public class ForecastEngine {

    private final Map<Integer, Double> memo = new HashMap<>();

    // ── 1. Plain Recursive (safe for small n) ─────────────────────────
    public double calculateFutureValue(double presentValue,
                                       double annualRate,
                                       int years) {
        if (years == 0) return presentValue;
        return calculateFutureValue(presentValue, annualRate, years - 1)
                * (1 + annualRate);
    }

    // ── 2. Memoized — iterative fill to avoid stack overflow ──────────
    // Simulates memoization by building cache bottom-up (DP style)
    public double calculateFutureValueMemo(double presentValue,
                                           double annualRate,
                                           int years) {
        if (memo.containsKey(years)) return memo.get(years);

        // Build cache iteratively from year 0 upward
        double value = presentValue;
        for (int i = 1; i <= years; i++) {
            if (!memo.containsKey(i)) {
                value = value * (1 + annualRate);
                memo.put(i, value);
            } else {
                value = memo.get(i);
            }
        }
        return memo.get(years);
    }

    // ── 3. Iterative ──────────────────────────────────────────────────
    public double calculateFutureValueIterative(double presentValue,
                                                double annualRate,
                                                int years) {
        double value = presentValue;
        for (int i = 1; i <= years; i++) {
            value *= (1 + annualRate);
        }
        return value;
    }

    // ── 4. Variable Growth Rate per Year ──────────────────────────────
    public double calculateVariableGrowth(double presentValue,
                                          double[] rates,
                                          int year) {
        if (year == 0) return presentValue;
        return calculateVariableGrowth(presentValue, rates, year - 1)
                * (1 + rates[year - 1]);
    }

    // ── 5. Compound Interest ───────────────────────────────────────────
    public double calculateCompoundInterest(double presentValue,
                                            double annualRate,
                                            int compoundingsPerYear,
                                            int totalPeriods) {
        if (totalPeriods == 0) return presentValue;
        double periodRate = annualRate / compoundingsPerYear;
        return calculateCompoundInterest(
                presentValue, annualRate, compoundingsPerYear, totalPeriods - 1)
                * (1 + periodRate);
    }

    public void clearCache() { memo.clear(); }
}
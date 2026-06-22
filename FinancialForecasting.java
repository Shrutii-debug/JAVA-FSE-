class FinancialForecaster {

    
    public static double predictFutureValueRecursive(double presentValue, double growthRate, int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }
        
        if (years == 0) {
            return presentValue;
        }
        
        return predictFutureValueRecursive(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    
    public static double predictFutureValueIterative(double presentValue, double growthRate, int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }

  
    public static double predictFutureValueFormula(double presentValue, double growthRate, int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative");
        }
        return presentValue * Math.pow(1 + growthRate, years);
    }
}

public class FinancialForecasting {
    public static void main(String[] args) {
        double presentValue = 100000.0; // e.g., ₹1,00,000 initial investment
        double growthRate = 0.08;       // 8% annual growth
        int years = 5;

        System.out.println("--- Inputs ---");
        System.out.printf("Present Value: %.2f, Growth Rate: %.2f%%, Years: %d%n",
                presentValue, growthRate * 100, years);

        double recursiveResult = FinancialForecaster.predictFutureValueRecursive(presentValue, growthRate, years);
        System.out.printf("%nRecursive result: %.2f%n", recursiveResult);

        double iterativeResult = FinancialForecaster.predictFutureValueIterative(presentValue, growthRate, years);
        System.out.printf("Iterative result: %.2f%n", iterativeResult);

        double formulaResult = FinancialForecaster.predictFutureValueFormula(presentValue, growthRate, years);
        System.out.printf("Formula result:   %.2f%n", formulaResult);

        System.out.println("\n--- Edge case: years = 0 ---");
        System.out.printf("Result: %.2f (should equal present value unchanged)%n",
                FinancialForecaster.predictFutureValueRecursive(presentValue, growthRate, 0));

        System.out.println("\n--- Edge case: negative growth rate (depreciation) ---");
        System.out.printf("Result over 3 years at -10%%/year: %.2f%n",
                FinancialForecaster.predictFutureValueRecursive(presentValue, -0.10, 3));
    }
}

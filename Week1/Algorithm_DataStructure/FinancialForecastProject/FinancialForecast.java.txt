public class FinancialForecast {

    
    public static double futureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        } else {
            return futureValue(initialValue, growthRate, periods - 1) * (1 + growthRate);
        }
    }

    public static void main(String[] args) {
        double initial = 1000.0;   
        double rate = 0.05;        
        int n = 10;                

        double result = futureValue(initial, rate, n);
        System.out.printf("Future value after %d periods: %.2f\n", n, result);
    }
}

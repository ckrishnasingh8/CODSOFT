import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class CurrencyConverter {
    private static final Map<String, Double> EXCHANGE_RATES = new HashMap<>();

    static {
        EXCHANGE_RATES.put("USD", 1.0);
        EXCHANGE_RATES.put("EUR", 0.92); // 1 USD = 0.92 EUR (approx)
        EXCHANGE_RATES.put("GBP", 0.79); // 1 USD = 0.79 GBP (approx)
        EXCHANGE_RATES.put("JPY", 156.0); // 1 USD = 156.0 JPY (approx)
        EXCHANGE_RATES.put("CAD", 1.37); // 1 USD = 1.37 CAD (approx)
        EXCHANGE_RATES.put("AUD", 1.51); // 1 USD = 1.51 AUD (approx)
        EXCHANGE_RATES.put("INR", 83.5); // 1 USD = 83.5 INR (approx)
        EXCHANGE_RATES.put("CNY", 7.24); // 1 USD = 7.24 CNY (approx)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.println("----------------------------------");
        System.out.println("Available Currencies:");
        for (String currencyCode : EXCHANGE_RATES.keySet()) {
            System.out.print(currencyCode + " ");
        }
        System.out.println("\n");

        String baseCurrency = "";
        String targetCurrency = "";
        double amountToConvert = 0.0;
        while (true) {
            System.out.print("Enter the base currency (e.g., USD, EUR): ");
            baseCurrency = scanner.nextLine().toUpperCase(); 
            if (EXCHANGE_RATES.containsKey(baseCurrency)) {
                break; 
            } else {
                System.out.println("Invalid base currency code. Please choose from the available currencies.");
            }
        }
        while (true) {
            System.out.print("Enter the target currency (e.g., JPY, GBP): ");
            targetCurrency = scanner.nextLine().toUpperCase(); 
            if (EXCHANGE_RATES.containsKey(targetCurrency)) {
                if (!targetCurrency.equals(baseCurrency)) { 
                    break; 
                } else {
                    System.out.println("Target currency cannot be the same as the base currency. Please choose a different one.");
                }
            } else {
                System.out.println("Invalid target currency code. Please choose from the available currencies.");
            }
        }
        while (true) {
            System.out.print("Enter the amount to convert from " + baseCurrency + " to " + targetCurrency + ": ");
            try {
                amountToConvert = scanner.nextDouble();
                if (amountToConvert >= 0) {
                    break; 
                } else {
                    System.out.println("Amount cannot be negative. Please enter a positive value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numerical value for the amount.");
                scanner.next(); 
            }
        }
        double convertedAmount = 0.0;
        try {
            double amountInUSD = amountToConvert / EXCHANGE_RATES.get(baseCurrency);
            convertedAmount = amountInUSD * EXCHANGE_RATES.get(targetCurrency);
        } catch (NullPointerException e) {
            System.err.println("Error: One of the currency codes was not found in the exchange rates map.");
            System.exit(1); 
        }
        System.out.println("\n--- Conversion Result ---");
        System.out.printf("%.2f %s is equal to %.2f %s\n", amountToConvert, baseCurrency, convertedAmount, targetCurrency);
        System.out.println("-------------------------");

        scanner.close(); 
    }
}

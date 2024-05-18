import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();


        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "CAD");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "HKD");
        currencyCodes.put(5, "INR");


        String fromCode, toCode;
        double amount;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the currency conventer!");

        System.out.println("Currencty converting FROM?");

        System.out.println("1: USD (Dollar)  \t 2:CAD (Canadian Dollar) " +
                "\t 3:EUR (Euro) \t 4:HKD (Hong Kong Dollar) \t 5:INR (Indian Rupee)");

        fromCode = currencyCodes.get(scanner.nextInt());

        System.out.println("Currencty converting TO?");

        System.out.println("1: USD (Dollar)  \t 2:CAD (Canadian Dollar) " +
                "\t 3:EUR (Euro) \t 4:HKD (Hong Kong Dollar) \t 5:INR (Indian Rupee)");

        toCode = currencyCodes.get(scanner.nextInt());





    }
}

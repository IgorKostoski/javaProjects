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


    }
}

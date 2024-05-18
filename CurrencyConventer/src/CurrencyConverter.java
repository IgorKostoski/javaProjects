import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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


        System.out.println("Amount you wish to convert?");

        amount = scanner.nextFloat();

        String apiKey =  "http://api.exchangeratesapi.io/v1/latest?access_key=225650f2c8869c0a8f13a4027da15ee4";


//


        System.out.println("Thank you for using the conventer!");





    }

    private static void sendHttpGetRequest(String apiKey, String fromCode,String toCode,String amount) throws IOException {

        String GET_URL = "https://api.exchangeratesapi.io/latest?base=" + toCode + "&symbols=" +fromCode;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("GET");

        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;

            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }in.close();

            JSONObject obj = new JSONObject(response.toString());
        }

    }
}

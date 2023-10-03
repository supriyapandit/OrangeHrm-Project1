package base;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class reader {
	  public static String existingUser(String data) throws IOException, ParseException {
	        JSONParser jsonParser = new JSONParser();
	        FileReader fileReader = new FileReader("src\\test\\resources\\data\\existinguser.reader");
	        Object obj = jsonParser.parse(fileReader);
	        JSONObject existingUser = (JSONObject) obj;
	        return (String)existingUser.get(data);
	    }

	    public static String accountDetails(String data) throws IOException, ParseException {
	        JSONParser jsonParser = new JSONParser();
	        FileReader fileReader = new FileReader("src\\test\\resources\\data\\Accdetials.reader");
	        Object obj = jsonParser.parse(fileReader);
	        JSONObject accountDetails = (JSONObject) obj;
	        return (String)accountDetails.get(data);
	    }

	    public static String paymentDetails(String data) throws IOException, ParseException {
	        JSONParser jsonParser = new JSONParser();
	        FileReader fileReader = new FileReader("src\\test\\resources\\data\\payment.reader");
	        Object obj = jsonParser.parse(fileReader);
	        JSONObject paymentDetails = (JSONObject) obj;
	        return (String)paymentDetails.get(data);
	    }

	    public static String poloBrandProducts(String data) throws IOException, ParseException {
	        JSONParser jsonParser = new JSONParser();
	        FileReader fileReader = new FileReader("src\\test\\resources\\data\\polobrandproduct.reader");
	        Object obj = jsonParser.parse(fileReader);
	        JSONObject poloBrandProducts = (JSONObject) obj;
	        return (String)poloBrandProducts.get(data);
	    }

	    public static String HMProduct(String data) throws IOException, ParseException {
	        JSONParser jsonParser = new JSONParser();
	        FileReader fileReader = new FileReader("src\\test\\resources\\data\\H&M.reader");
	        Object obj = jsonParser.parse(fileReader);
	        JSONObject madameBrandProducts = (JSONObject) obj;
	        return (String)madameBrandProducts.get(data);
	    }
}

/**
 * Handles parsing of a food order receipt
 */

import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileNotFoundException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
* Parses Food Receipt Order and returns a json file with data to send to
* firebase
*/
public class ReceiptParser {

    public static Order Parse(String fileName) {
        // automate so parse runs for every new file added to folder = new
        // incoming order
        JSONParser parser = new JSONParser();

//        HashMap<String, String> json = new HashMap<>();
//        HashMap<String, Dish> dishes = new HashMap<>();
//        HashMap<String, String> customer = new HashMap<>();

        try {
            // Parser file into object
            Object obj = parser.parse(new FileReader(fileName));

            // Converting object into JSONObject
            JSONObject jsonObject =  (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            String city = (String) jsonObject.get("city");
            System.out.println(city);

            String job = (String) jsonObject.get("job");
            System.out.println(job);

            // loop array
            JSONArray cars = (JSONArray) jsonObject.get("cars");
            Iterator<String> iterator = cars.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        try {
//            Scanner scanner = new Scanner(new File(fileName));
//            while(scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                System.out.println(line);
//                //access restaurant name from database
//
//                if(line.contains("Order ID")) {
//                    line = line.replace("Order ID: ", "").trim();
//                    json.put("orderID", line);
//                } else if(line.contains("Customer")) {
//                    String[] names =
//                            line.replace("Customer: ", "").split(" ");
//                    String fName = names[0];
//                    String lName = names[1];
//                    customer.put("firstName", fName);
//                    customer.put("lastName", lName);
//                } else {
//                    // ...
//                }
//            }
//                scanner.close();
//        } catch(FileNotFoundException e) {
//            e.printStackTrace();
//        }
        //placeholder
        return new Order("", "", "");
        //figure out how to send the json file to Firebase
    }



};

/**
 * Handles parsing of a food order receipt
 */

import java.io.*;
import java.util.HashMap;

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

    public static void Parse(String fileName) {
        // automate so parse runs for every new file added to folder = new
        // incoming order
        JSONParser parser = new JSONParser();
        JSONObject order = new JSONObject();

        HashMap<String, String> fields = new HashMap<>();
//        HashMap<String, Dish> orders = new HashMap<>();
        ArrayList<Order> orders = new ArrayList<>();
        HashMap<String, String> customer = new HashMap<>();

//        try {
//            // Parser file into object
//            Object obj = parser.parse(new FileReader(fileName));
//
//            // Converting object into JSONObject
//            JSONObject jsonObject =  (JSONObject) obj;
//
////            String name = (String) jsonObject.get("name");
////            System.out.println(name);
////
////            String city = (String) jsonObject.get("city");
////            System.out.println(city);
////
////            String job = (String) jsonObject.get("job");
////            System.out.println(job);
////
////            String deferDue = (String) jsonObject.get("DeferDue");
////            System.out.println(deferDue);
////
////            // loop array
////            JSONArray cars = (JSONArray) jsonObject.get("cars");
////            Iterator<String> iterator = cars.iterator();
////            while (iterator.hasNext()) {
////                System.out.println(iterator.next());
////            }
//
//            System.out.println((String) jsonObject.get("Order Number"));
//
//            //TBD
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
//                System.out.println(line);
                //access restaurant name from database

                if(line.startsWith("Order ID:") || line.startsWith("Order Number")) {
                    //check  that both Order ID and Order Number are taken
                    // out of the string
                    line = line.replace("Order ID: ", "").trim();
                    line = line.replace("Order Number: ", "").trim();
                    fields.put("orderID", line);
                    System.out.println(fields.get("orderID"));
                }
                else if(line.contains("Delivered")) {
                    fields.put("delivery", "Delivery");
                    System.out.println(fields.get("delivery"));
                }
                else if(line.startsWith("Customer:")) {
                    String[] names =
                            line.replace("Customer: ", "").split(" ");
                    String fName = names[0];
                    String lName = names[1];
                    customer.put("firstName", fName);
                    customer.put("lastName", lName);
                    System.out.println("first name: " + fName + "\nlast name:" +
                            " " + lName);
                } else if (line.startsWith("Order Details")){
                   String detailLine = "";
                   String dishName = "";
                   double itemPrice = 0.0; // 2 vars for price?
                   String description = "";
                   int qty = 0;
                   String specialInstructions = "";
                   while (scanner.hasNextLine()) {
                        detailLine = scanner.nextLine();

                   }
                }
            }
            // fill in the default values
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        //placeholder
       // return new Order("", "", "");
        //figure out how to send the json file to Firebase
    }



};

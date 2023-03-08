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

        HashMap<String, String> strFields = new HashMap<>();
        HashMap<String, Double> numFields = new HashMap<>();
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
            String line = "";
            String prevLine = "";
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
//                System.out.println(line);
                //access restaurant name from database

                if(line.startsWith("Order ID:") || line.startsWith("Order Number")) {
                    //check  that both Order ID and Order Number are taken
                    // out of the string
                    line = line.replace("Order ID: ", "").trim();
                    line = line.replace("Order Number: ", "").trim();
                    strFields.put("orderID", line);
                    System.out.println(strFields.get("orderID"));
                }
                else if(line.contains("Delivered")) {
                    strFields.put("delivery", "Delivery");
                    System.out.println(strFields.get("delivery"));
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
                }
                else if (line.startsWith("Order Details")){
                   String dishName = "";
                   double itemPrice = 0.0; // 2 vars for price?
                   ArrayList<Option> options = new ArrayList<>();
                   String description = "";
                   int qty = 0;
                   String specialInstruction = "";
                   while (scanner.hasNextLine() && !line.equals("Subtotal")) {
                        line = scanner.nextLine();
                        // loop through each specific order
                        while(scanner.hasNextLine() && !line.equals("Subtotal")) {
                            //Get quantity of an order
                            if(Character.isDigit(line.charAt(0)) && line.endsWith("x")) {
                                qty = Integer.parseInt(line.substring(0, 1));
                                System.out.println(qty);
                            } // Get dish name and description
                            else if(Character.isDigit(prevLine.charAt(0)) && prevLine.endsWith("x")) {
                                int index = line.indexOf("(");
                                dishName = line.substring(0, index).trim();
                                description = line.substring(index + 1,
                                        line.length() - 1).trim();
                                System.out.println("Dish Name: " + dishName);
                                System.out.println("Description: " + description);
                            } // Option handling
                            else if (line.contains("Addition") || line.contains("Choice")) {
                                String[] splitLine = line.split(":");
                                String key = splitLine[0].trim();
                                String value =
                                        splitLine[1].trim().replace("(", "").replace(")", "");
                                double optionPrice = 0.0;
                                if(value.contains("$")) {
                                    int index = value.indexOf("$");
                                    optionPrice =
                                            Double.parseDouble(value.substring(index + 1));
                                    value = value.substring(0,
                                            index);
                                }
                                System.out.println("OptionName: " + value);
                                System.out.println("OptionPrice: " + optionPrice);
                                options.add(new Option(value, optionPrice));
                            }
                            else if (line.startsWith("Special Instructions")) {
                                specialInstruction =
                                        line.substring(20).trim();
                                System.out.println(specialInstruction);
                            } //Price of Order and adding final Order object
                            // to order list
                            else if(line.startsWith("$")) {
                                itemPrice =  Double.parseDouble(line.substring(1));
                                System.out.println(itemPrice);
                                //add order to arrayList
                                Option[] opts = options.toArray(new Option[0]);
//                                for (Option o : opts) {
//                                    System.out.println( "optionName: " + o.optionName + ", price: " + o.price);
//                                }
                                orders.add(new Order(dishName, itemPrice,
                                        opts, 0, qty,
                                        specialInstruction, description, "id"
                                        , "image", "menuLogoURL"));
                                break;
                            }
                            prevLine = line;
                            line = scanner.nextLine();
                        }

                   }
                }
                else if (prevLine.startsWith("Subtotal")) {
                    line = line.replace("$", "");
                    double subtotal = Double.parseDouble(line);
                    numFields.put("subTotal", subtotal);
                    System.out.println(line);

                }
                else if (prevLine.startsWith("Tax")) {
                    line = line.replace("$", "");
                    double tax = Double.parseDouble(line);
                    numFields.put("taxTotal", tax);
                    System.out.println(line);
                }

                prevLine = line;
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

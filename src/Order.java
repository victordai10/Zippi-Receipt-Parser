/**
 * Creates the food order object with all underlying details
 */

public class Order {
    // list of initialized variables
    public String dishName, specialInstruction, description, id, image,
            menuLogoURL;
    public Double itemPrice, price;
    public int qty;
    public Option[] options;

    //figure out fields: customer, hub, restaurants, restaurantFilter, and
    // payments


//    public class customer {
//
//        public String email, fName, lName, mobile, userType, addr, uid;
//        public Double[] coords;
//        public String[] tokens;
//        public customer(String email, String fName, String lName,
//                        String mobile, String userType, String addr,
//                        Double[] coords, String[] tokens, String uid) {
//            this.email = email;
//            this.fName = fName;
//            this.lName = lName;
//            this.mobile = mobile;
//            this.userType = userType;
//            this.addr = addr;
//            this.coords = coords;
//            this.tokens = tokens;
//            this.uid = uid;
//        }


//        public String toString() {
//            return String.format("{" +
//                    "Email: " + this.email +
//                    "FirstName: " + this.fName +
//                    "LastName: " + this.lName +
//                    "MobilePhone: " + this.mobile +
//                    "UserType: " + this.userType +
//                    "address: " + this.addr +
//                    "coords: " + this.coords +
//                    "tokens: " + this.tokens +
//                    "uid: " + this.uid +
//                    "}");
//        }
    //} // end of customer

    public class Option {
        String optionName;
        double price;
        public class Ingredient {
            String ingredients;
            double price;
            public Ingredient(String ingredients, double price) {
                this.ingredients = ingredients;
                this.price = price;
            }
        }
        Ingredient[] ingredients;
        public Option(String optionName, double price,
                      Ingredient[] ingredients) {
            this.optionName = optionName;
            this.price = price;
            this.ingredients = ingredients;
        }

    }



    public Order(String dishName, double itemPrice, Option[] options,
                 double price, int qty
            , String specialInstruction, String description, String id,
                 String image, String menuLogoURL) {
            this.dishName = dishName;
            this.itemPrice = itemPrice;
            this.options = options;
            this.price = price;
            this.specialInstruction = specialInstruction;
            this.description = description;
            this.id = id;
            this.image = image;
            this.menuLogoURL = menuLogoURL;

    }
}

/**
 * Creates the food order object with all underlying details
 */

public class Order {
    // list of initialized variables
    private String creationDate, customerId, deferDue, delivery,
            deliveryService, lastTimeUpdated, ordState, orderId;
    private Double secondPrice, subTotal, taxRate, taxTotal, tip, total,
            totalDeliveryFee, totalRefund;
    //figure out fields: customer, hub, restaurants, restaurantFilter, and
    // payments


    public class customer {

        public String email, fName, lName, mobile, userType, addr, uid;
        public Double[] coords;
        public String[] tokens;
        public customer(String email, String fName, String lName,
                        String mobile, String userType, String addr,
                        Double[] coords, String[] tokens, String uid) {
            this.email = email;
            this.fName = fName;
            this.lName = lName;
            this.mobile = mobile;
            this.userType = userType;
            this.addr = addr;
            this.coords = coords;
            this.tokens = tokens;
            this.uid = uid;
        }


        public String toString() {
            return String.format("{" +
                    "Email: " + this.email +
                    "FirstName: " + this.fName +
                    "LastName: " + this.lName +
                    "MobilePhone: " + this.mobile +
                    "UserType: " + this.userType +
                    "address: " + this.addr +
                    "coords: " + this.coords +
                    "tokens: " + this.tokens +
                    "uid: " + this.uid +
                    "}");
        }
    } // end of customer




    public Order(String fName, String lName, String email) {

    }
}

/**
 * Creates the food order object with all underlying details
 */

public class Order {
    // list of initialized variables
    private String fName, lName, email;
    private Double price, subtotal, serviceFee, deliveryFee;




    public Order(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;

    }
}

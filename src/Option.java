/**
 * Serves as class for Option
 */

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
    //Ingredient[] ingredients;
    public Option(String optionName, double price) {
        //, Ingredient[] ingredients
        this.optionName = optionName;
        this.price = price;
//        this.ingredients = ingredients;
    }

    public String toString(Option[] opts) {
        String str = "";
        for (Option o : opts) {
            str += "optionName: " + o.optionName + ", price: " + o.price + "\n";
        }
        return str;
    }

}
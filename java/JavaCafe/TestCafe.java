import java.util.*;

public class TestCafe {
    public static void main(String[] args) {
    CafeUtil appTest = new CafeUtil(); 

    //1
    System.out.println(appTest.getStrekGoal(10));

    
    //2
    double[] lineItems = {3.5, 1.5, 4.0, 4.5};
    System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));

    //3
    ArrayList<String> menu = new ArrayList<String>();
    menu.add("drip coffee");
    menu.add("cappuccino");
    menu.add("latte");
    menu.add("mocha");
    appTest.displayMenu(menu);


    //4
    ArrayList<String> customers = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }







    }


}
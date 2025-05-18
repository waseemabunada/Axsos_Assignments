import java.util.ArrayList;

public class CafeUtil {
    public int getStrekGoal(int NumWeeks) {
        int sum = 0;
        for (int i = 0; i <= NumWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Enter your name please");
        String username = System.console().readLine();
        System.out.println("Hello" + username);
        customers.add(username);
        System.out.println("There are" + " " + customers.size() + "people in front of you");
        System.out.println(customers);
    }
}

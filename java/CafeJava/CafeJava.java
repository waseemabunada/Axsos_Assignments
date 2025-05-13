public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.0;
        double lattePrice = 4.5;
        double cappuccinoPrice = 3.8;

        // Customer name variables
        String customer1 = "Shatha";
        String customer2 = "Ahmad";
        String customer3 = "Sali";
        String customer4 = "Adam";

        // Order completion flags
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true; // Ahmad
        boolean isReadyOrder3 = false; // Sali
        boolean isReadyOrder4 = true; // Adam

        // APP INTERACTION SIMULATION
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Shatha"
        System.out.println("--------------------------------");
        // Sali ordered a coffee
        if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
        } else {
            System.out.println(customer3 + pendingMessage);
        }
        System.out.println("--------------------------------");

        // Ahmad ordered a cappuccino
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(customer2 + pendingMessage);
        }
        System.out.println("--------------------------------");

        // Sali just ordered 2 lattes
        System.out.println(displayTotalMessage + (2 * lattePrice));
        if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
        } else {
            System.out.println(customer3 + pendingMessage);
        }
        System.out.println("--------------------------------");

        // Adam was charged for a coffee but ordered a latte
        double priceDifference = lattePrice - dripCoffeePrice;
        System.out.println("Oops! You were charged for coffee instead of a latte.");
        System.out.println("Additional amount owed: $" + priceDifference);
    }
}

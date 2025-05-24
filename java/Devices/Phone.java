public class Phone extends Device { // inherits from the `Device`

    public void makeCall() {
        if (battery >= 5) {
            battery -= 5;

            System.out.println("You make a call.");
        } else {
            System.out.println("Not enough battery to make a call.");
            batteryStatus();
            checkBattery();

        }
    }

    public void playGame() {
        if (battery < 25) {
            System.out.println("Battery too low to play a game.");
        } else {
            battery -= 20;
            System.out.println("You play a game.");
        }
        batteryStatus();
        checkBattery();

    }

    public void charge() {
        battery += 50;
        if (battery >= 100) {
            battery = 100;

        }
        System.out.println("You charge the phone.");
        batteryStatus();
        checkBattery();

    }

    private void checkBattery() {
        if (battery < 10) {
            System.out.println("Warning: Battery critical!");
        }

    }
}
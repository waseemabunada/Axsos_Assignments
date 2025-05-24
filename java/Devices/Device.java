public class Device {
    public int battery;

    // استخدمت constructer لان بدي اعطي قيمة اولية للبطارية 
    public Device(){
        this.battery=100;

    }

public void batteryStatus() {
        System.out.println("Battery remaining: " + battery + "%");
    }
}
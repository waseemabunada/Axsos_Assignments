import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class NewClass {
public class Maps {
    public static void main(String[] args){
        HashMap<String, String> countryCapitals = new HashMap<String, String>();

        // أضف 5 دول وعواصمها
        countryCapitals.put("Palestine", "Jerusalem");
        countryCapitals.put("Jordan", "Amman");
        countryCapitals.put("Lebanon", "Beirut");
        countryCapitals.put("Egypt", "Cairo");
        countryCapitals.put("Oman", "Muscat");


        Set<String> keys = countryCapitals.keySet();
        for(String country : keys) {
            System.out.println(country);
        }

        System.out.println("The capital of Oman is " + countryCapitals.get("Oman") + ".");
        System.out.println("The capital of Palestine is " + countryCapitals.get("Palestine") + ".");
    }

}}
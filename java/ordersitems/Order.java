package Java_OOP.ordersitems;

import java.util.ArrayList;

public class Order {
    String name;
    Double total;
    Boolean ready;
    ArrayList<Item> items;

    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<>();
    }

    public Order() {
    }

    public void addItem(Item item){
        this.total+=item.price;
        this.items.add(item);
        System.out.println(this.name+" ordered "+item.name+", price is $"+item.price+", total is $"+this.total);
    }
    public void makeReady(){
        this.ready=true;
        System.out.println(this.name+"'s order is ready");
    }

}


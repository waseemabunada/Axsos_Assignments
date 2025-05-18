package Java_OOP.ordersitems;

import java.util.ArrayList;

public class Order {
    private String name;
    private Double total;
    private Boolean ready;
    private ArrayList<Item> items;

    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<>();
    }

    public Order() {
    }

    public void addItem(Item item){
        this.total+=item.getPrice();
        this.items.add(item);
        System.out.println(this.name+" ordered "+item.getName()+", price is $"+item.getPrice()+", total is $"+this.total);
    }
    public void makeReady(){
        this.ready=true;
        System.out.println(this.name+"'s order is ready");
    }

    public String getStatus(){
        if(this.ready){
            return "the order is ready to pickup, "+this.name+". thanks for waiting.";
        }
        return "thank you for waiting, "+this.name+". the order will be ready soon.";
    }

    public void display(){
        System.out.println("Customer: "+this.name);
        for (Item item : this.items){
            System.out.println(item.getName()+" - $"+item.getPrice());
        }
        System.out.println("Total: $"+this.total);
    }

    public Double calculateTotal(){
        Double sum=0.0;
        for (Item item : this.items){
            sum+=item.getPrice();
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}


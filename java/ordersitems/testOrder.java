package Java_OOP.ordersitems;

public class testOrder {
    public static void main(String[] args) {

        Item[] items={
                new Item("chips",3.0),
                new Item("chocolate",4.0),
                new Item("chat",2.0),
                new Item("marlboro",20.0),
                new Item("cappuccino",10.0)
        };
        Order[] orders={
                new Order("ahmad"),
                new Order("wasim"),
                new Order("bahaa"),
                new Order("mahmoud")
        };
        //ahmad
        orders[0].addItem(items[0]);
        orders[0].addItem(items[1]);
        //wasim
        orders[1].addItem(items[0]);
        orders[1].addItem(items[2]);
        orders[1].addItem(items[3]);
        //bahaa
        orders[2].addItem(items[2]);
        //mahmoud
        orders[3].addItem(items[0]);
        orders[3].addItem(items[3]);

        System.out.println(orders[0].items);

        System.out.println(orders[0].total);

        //order prepared
        orders[0].makeReady();

        orders[1].addItem(items[4]);
        orders[1].addItem(items[4]);

        orders[2].makeReady();




    }
}

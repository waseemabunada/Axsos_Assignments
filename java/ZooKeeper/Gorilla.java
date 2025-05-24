public class Gorilla extends Mammal {

    public void throwSomething() {
        energy -= 5;
        System.out.println("The gorilla has thrown an object");
    }

    public void eatBananas() {
        energy += 10;
        System.out.println("The gorilla enjoys the bananas");
    }

    public void climb() {
        energy -= 10;
        System.out.println("The gorilla climbed a tree");
    }
}

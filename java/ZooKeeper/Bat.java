public class Bat extends Mammal {

    public Bat() {
        this.energy = 300; 
    }

    public void fly() {
        energy -= 50;
        System.out.println("The bat is flying");
    }

    public void eatHumans() {
        energy += 25;
        System.out.println("The bat has eaten humans and feels satisfied");
    }

    public void attackTown() {
        energy -= 100;
        System.out.println("The bat attacked a town");
    }
}

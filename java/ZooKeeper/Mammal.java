public class Mammal {
    public int energy;

    public Mammal() {
        this.energy = 100; 
    }

    public int displayEnergy() {
        System.out.println("Energy level: " + energy);
        return energy;
    }
}

public class ZooKeeperTest {
    public static void main(String[] args) {
        // Gorilla test
        Gorilla gorilla = new Gorilla();

        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.throwSomething();

        gorilla.eatBananas();
        gorilla.eatBananas();

        gorilla.climb();

        gorilla.displayEnergy();

        System.out.println("---------------------");

        //Bat test
        Bat bat = new Bat();

        bat.attackTown();
        bat.attackTown();
        bat.attackTown();

        bat.eatHumans();
        bat.eatHumans();

        bat.fly();
        bat.fly();

        bat.displayEnergy();
    }
}

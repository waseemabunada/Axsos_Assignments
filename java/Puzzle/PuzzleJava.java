import java.util.Random;

public class PuzzleJava {
    public static int[] getTenRolls() {
        int[] rolls = new int[10];
        Random randMachine = new Random();

        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = randMachine.nextInt(20) + 1; 
        }

        return rolls;
    }
}






















    

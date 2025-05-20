import java.util.Random;

public class PuzzleJava {

    public int[] getTenRolls() {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int rand = r.nextInt(20) + 1;
            arr[i] = rand;
        }
        return arr;
    }

    public char getRandomLetter() {
        char[] alphabet = new char[26];

        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) (i + 'a');
        }
        Random rand = new Random();
        int index = rand.nextInt(26);
        return alphabet[index];
    }

    public String generatePassword(){
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();   
        }
        return password;
    }
    
    public String[] getNewPasswordSet(int length) {
        String[] passwords = new String[length];
        for (int i = 0; i < length; i++) {
            passwords[i] = generatePassword();
        }
        return passwords;
    }



}

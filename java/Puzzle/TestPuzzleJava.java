public class TestPuzzleJava {
    public static void main(String[] args) {
        PuzzleJava appJava = new PuzzleJava();

        int[] results = appJava.getTenRolls();
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
            System.out.println("Random letter: " + appJava.getRandomLetter());
        }
        System.out.println(appJava.generatePassword());

        String[] passwords = appJava.getNewPasswordSet(5);
        for (int i = 0; i < passwords.length; i++) {
            System.out.println("Generated Password: " + passwords[i]);
        }
    }
}

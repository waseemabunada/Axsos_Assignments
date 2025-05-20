public class BankTest {
    public static void main(String[] args) {
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount(0, 0);
        BankAccount account2 = new BankAccount(0, 0);
        BankAccount account3 = new BankAccount(0, 0);

        account1.depositChecking(500);
        System.out.println(account1.getCheckingBalance());

        account1.WithdrawChecin(800);
        System.out.println(account1.WithdrawChecin(800));
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and
        // display the balance each time
        // - each deposit should increase the amount of totalMoney

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account
        // and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney

        // Static Test (print the number of bank accounts and the totalMoney)

    }
}
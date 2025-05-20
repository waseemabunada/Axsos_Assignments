public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    
    private double savingsBalance;
    
    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances
    
    
    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accounts++;
    }
    
    public BankAccount() {
        
    }
    
    // GETTERS
    // for checking, savings, accounts, and totalMoney
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public static int getAccounts() {
        return accounts;
    }

    public static void setAccounts(int accounts) {
        BankAccount.accounts = accounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }

    public static void setTotalMoney(double totalMoney) {
        BankAccount.totalMoney = totalMoney;
    }

    

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account

public void depositChecking(double amount){
    this.checkingBalance += amount ;
    this.totalMoney += amount;
} 

public void depositSaving(double amount){
    this.checkingBalance += amount ;
    this.totalMoney += amount;
} 



    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
public Boolean WithdrawChecin( double amount){
    if (this.getCheckingBalance()-amount > 0){
        this.setCheckingBalance(getCheckingBalance()-amount);
        this.totalMoney -= amount;
        return true;
    }
    return false;

}

    // getBalance
    // - display total balance for checking and savings of a particular bank account
}
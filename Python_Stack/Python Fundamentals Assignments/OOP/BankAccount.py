class BankAccount:
    def __init__(self, int_rate, balance=0):  
        self.int_rate = int_rate
        self.balance = balance
        

   
    def deposit(self, amount):
        self.balance += amount
        return self

   
    def withdraw(self, amount):
        if self.balance >= amount:
            self.balance -= amount
            return self
        else:
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
            return self

    
    def display_account_info(self):
        print("Balance: $" + str(self.balance))
        return self

    def yield_interest(self):
        if (self.balance > 0):
            self.balance = self.balance + self.balance * self.int_rate
            return self


account = BankAccount(0.05, 100).display_account_info() .deposit(50).display_account_info() 


account.withdraw(50).display_account_info() 


account.withdraw(200).display_account_info() 


account.yield_interest().display_account_info() 
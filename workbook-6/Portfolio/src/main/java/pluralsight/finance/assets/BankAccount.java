package pluralsight.finance.assets;

import pluralsight.finance.interfaces.Valuable;

public class BankAccount implements Valuable {

    String name, accountNumber;
    double balance;

    public BankAccount(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public void withdraw(double amount){
        balance-=amount;
    }
    @Override
    public double getValue() {
        return balance;
    }
}

package BankAccount;

public class Bank {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate =  DEFAULT_INTEREST_RATE;
    private static int idCounter = 1;
    private int id;
    private double balance;

    Bank (){
        this.id = idCounter++;
        this.balance = 0;
    }

    public static void setInterestRate(double interestRate) {
        Bank.interestRate = interestRate;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    double getInterestRate (int years) {
        return interestRate * years * balance;
    }

    public int getId() {
        return this.id;
    }
}

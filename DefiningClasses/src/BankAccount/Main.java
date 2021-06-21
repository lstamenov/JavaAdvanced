package BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        List<Bank> bankList = new ArrayList<>();
        while (!input.equals("End")){
            String[] command = input.split("\\s+");
            switch (command[0]){
                case "Create":
                    Bank bank = new Bank();
                    bankList.add(bank);
                    System.out.printf("Account ID%d created%n",bank.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(command[1]);
                    int amount = Integer.parseInt(command[2]);
                    try {
                        bankList.get(id - 1).deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n",amount, id);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Account does not exist");
                    }
                    break;
                case "GetInterest":
                    id = Integer.parseInt(command[1]);
                    int years = Integer.parseInt(command[2]);
                    try {
                        double a = bankList.get(id - 1).getInterestRate(years);
                        System.out.printf("%.2f%n", a);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    Bank.setInterestRate(Double.parseDouble(command[1]));
                    break;
            }
            input = bufferedReader.readLine();
        }
    }
}

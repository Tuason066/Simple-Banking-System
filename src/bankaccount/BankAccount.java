/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankaccount;

import java.util.Scanner;

/**
 *
 * @author Tuason
 */




public class BankAccount {

    /**
     * @param args the command line arguments
     */
    
    private float balance = 0.00f;
    private String accountHolderName;
    private String accountNumber;
    
    public BankAccount(String name, String accountNumber) {
        this.accountHolderName = name;
        this.accountNumber = accountNumber;
    }
    
    
    public static void main(String [] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        
        // ask name and account number
        System.out.print("Please enter your fullname: ");
        String accountHolderName = scan.nextLine();
        System.out.print("Please enter your account number: ");
        String accountNumber = scan.nextLine();
        
        BankAccount account = new BankAccount(accountHolderName, accountNumber);

        
        // ask what to do - withdraw / deposit
        String actions[] = {"withdraw", "deposit", "interest rate", "overdraft limit", "overdraft balance"};
        boolean isContinue = true;
        
        while(isContinue) {
            System.out.println("");
            System.out.println("Please select action from 0-" + (actions.length - 1));
            for(byte i = 0; i < actions.length; i++) {
                System.out.println(i + ". " + actions[i]);
            }

            System.out.print("Select: ");
            byte select = scan.nextByte();

            System.out.println("");
            
            // execute action (what to do)

            switch(select) {
                case 0 -> {
                    // display balance
                    System.out.println("Current Balance: P" + String.format("%.2f", account.getBalance()));
                    // ask value
                    System.out.print("Amount to " + actions[select] + "(P): ");
                    float value = scan.nextFloat();
                    scan.nextLine();
                    
                    // action
                    if(value <= account.getBalance()) {
                        account.withdraw(value);
                        System.out.println("Successfully " + actions[select] + " P" + String.format("%.2f", value) + " from your account. Your remaining total balance is P" + String.format("%.2f", account.getBalance()));
                    } else if( value > account.getBalance()) {
                        CheckingAccount overdraft = new CheckingAccount(accountHolderName, accountNumber);
                        overdraft.withdrawOverdraft(Math.abs(account.withdraw(value)));
                        account.balance = 0;
                        
                        System.out.println("You exceed to your account balance. You're withdrawing with your overdraft worth " + String.format("%.2f", Math.abs(account.withdraw(value))) + ". Your overdraft remaining balance is " + String.format("%.2f", overdraft.getOverdraftBalance()) + ". The amount you already borrowed is P" + String.format("%.2f", (1000 - overdraft.getOverdraftBalance())));
                    } else{
                        System.out.println("Failed: Insufficient funds. Your current balance is P" + String.format("%.2f", account.getBalance()));
                    }
                    
                    
                }
                
                case 1 -> {
                    // display balance
                    System.out.println("Current Balance: P" + String.format("%.2f", account.getBalance()));
                    // ask value
                    System.out.print("Amount to " + actions[select] + "(P): ");
                    float value = scan.nextFloat();
                    scan.nextLine();
                    
                    // action
                    account.deposit(value);
                    System.out.println("Successfully " + actions[select] + " P" + String.format("%.2f", value) + " to your account. Your current total balance is P" + String.format("%.2f", account.getBalance()));
                }
                
                case 2 -> {
                    scan.nextLine();
                    SavingsAccount mySaving = new SavingsAccount(accountHolderName, accountNumber);
                    System.out.println("Our interest rate is " + mySaving.getInterestRate() + "%");
                }
                
                case 3 -> {
                    scan.nextLine();
                    CheckingAccount checkAccount = new CheckingAccount(accountHolderName, accountNumber);
                    System.out.println("Our overdraft limit is P" + checkAccount.getOverdraftLimit() + ".00");
                }
                
                case 4 -> {
                    scan.nextLine();
                    CheckingAccount checkAccount = new CheckingAccount(accountHolderName, accountNumber);
                    System.out.println("Our overdraft limit is P" + String.format("%.2f", checkAccount.getOverdraftBalance()));
                }
            }
            
            
            // ask if they continue the transaction
            System.out.println("");
            System.out.println("Want to continue transaction? (Y)Yes (N)No");
  
            String toContinue = scan.nextLine();
            
            if(!toContinue.equalsIgnoreCase("Y")) {
                isContinue = false;
            } 
        }

    }

    public float withdraw(float toGet) {
        this.balance = this.balance - toGet;
        return this.balance;
    }
    
    
    public float deposit(float toAdd) {
        this.balance += toAdd;
        return this.balance;
    }
    
    public float getBalance() {
        return this.balance;
    }
    
}
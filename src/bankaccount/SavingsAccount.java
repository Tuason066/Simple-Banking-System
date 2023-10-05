/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccount;

/**
 *
 * @author Tuason
 */
public class SavingsAccount extends BankAccount {
    
    byte interestRate = 5;
    
    public SavingsAccount(String name, String accountNumber) {
        super(name, accountNumber);
    }
    
    public byte getInterestRate() {
        return this.interestRate;
    }
    
}

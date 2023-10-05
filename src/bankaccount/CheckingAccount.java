/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankaccount;

/**
 *
 * @author Tuason
 */
public class CheckingAccount extends BankAccount{
    
    short overdraftLimit = 1000;
    float overdraftBalance = 1000;
    
    
    public CheckingAccount(String name, String accountNumber) {
        super(name, accountNumber);
    }
    
    public float getOverdraftBalance() {
        return overdraftBalance;
    }
    
    public short getOverdraftLimit() {
        return overdraftLimit;
    }
    
    public float withdrawOverdraft(float val) {
        this.overdraftBalance -= val;
        return this.overdraftBalance;
    }
    
}

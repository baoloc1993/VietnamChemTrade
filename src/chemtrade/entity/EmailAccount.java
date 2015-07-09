/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chemtrade.entity;

/**
 *
 * @author ASUS
 */
public class EmailAccount {
    
    private int accountID;
    private String accountType;
    private String emailAccount;
    private String status;

    public EmailAccount(int accountID, String accountType, String emailAccount, String status) {
        this.accountID = accountID;
        this.accountType = accountType;
        this.emailAccount = emailAccount;
        this.status = status;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public String getStatus() {
        return status;
    }
    
    
    
}

package test;

import org.junit.jupiter.api.Test;
import Model.Playerlist.Account;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void withdraw() {
        Account myAccount = new Account(1);
        myAccount.withdraw(2);
        int res = myAccount.getBalance();
        assertEquals(0,res);
    }

    @Test
    void deposit() {
        Account myAccount = new Account(1);
        myAccount.deposit(-2);
        int res = myAccount.getBalance();
        assertEquals(0,res);
    }

    @Test
    void setBalance(){
        Account myAccount = new Account(1);
        myAccount.setBalance(-1);
        int res = myAccount.getBalance();
        assertEquals(0,res);
    }

}
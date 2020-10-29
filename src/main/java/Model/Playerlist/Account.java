package Model.Playerlist;

public class Account {

    private int balance;

    /**
     * Creates a account that contains the balance of a account
     * @param balance   Balance of an account
     */
    public Account(int balance) {
        this.balance = balance;
    }

    /**
     * Method to withdraw money from an account
     * @param amount The amount you wish to withdraw
     */
    public void withdraw(int amount) {
        setBalance(getBalance()-amount);
        if (getBalance()<0) {
            setBalance(0);
        }
    }

    /**
     * Method to deposit money to an account
     * @param amount The amount you wish to deposit
     */
    public void deposit(int amount) {
        setBalance(getBalance()+amount);
        if (getBalance()<0) {
            setBalance(0);
        }
    }

    //Getters and setters
    public int getStartingBalance(){
        setBalance(1000);
        return balance; }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = Math.max(balance, 0);
    }


}
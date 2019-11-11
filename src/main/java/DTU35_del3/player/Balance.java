package DTU35_del3.player;

public class Balance {
    private String owner;
    private int balance;

    public Balance(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addToBalance(int amount) {
        this.balance += amount;
    }

    public void removeFromBalance(int amount) {
        this.balance -= amount;
    }
}

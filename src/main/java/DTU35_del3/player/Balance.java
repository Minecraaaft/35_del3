package DTU35_del3.player;

public class Balance {
    private int balance = 20;

    public Balance() {
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

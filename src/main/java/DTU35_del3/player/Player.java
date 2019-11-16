package DTU35_del3.player;

public class Player {

    // Attributes
    private String name;
    private static int playerNumber;
    private int fieldPos;
    private boolean hasLost;
    private Balance balance = new Balance();

    public Player() {
        this.name = "Player " + ++playerNumber;
        this.fieldPos = 0;

        this.hasLost = false;
    }


    //Getters
    public boolean getHasLost() {
        return hasLost;
    }
    public int getFieldPos() {
        return fieldPos;
    }
    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance.getBalance();
    }

    //Setters
    public void setName(String name) {
        if (name.length() == 0)
            return;
        this.name = name;
    }

    public void setBalance(int amount) {
        this.balance.setBalance(amount);
    }

    public void removeFromBalance(int amount) {
        this.balance.removeFromBalance(amount);
    }

    public void addToBalance(int amount) {
        balance.addToBalance(amount);
    }

    public void setHasWon(boolean hasLost) {
        this.hasLost = hasLost;
    }
    public void setFieldPos(int fieldPos) {
        this.fieldPos = fieldPos;
    }
    public static void setPlayerNumber(int playerNumber) { Player.playerNumber = playerNumber; }
}

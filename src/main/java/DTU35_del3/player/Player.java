package DTU35_del3.player;

public class Player {

    // Attributes
    private String name;
    private static int playerNumber;
    private int fieldPos;
    private boolean hasLost;
    private boolean inJail;
    private boolean hasJailCard;
    private boolean hasPlayerCard;
    private Balance balance = new Balance();
    private int fieldPosfoer;

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



    public boolean getInJail() {
        return inJail;
    }
    public int getFieldPosfoer() {return fieldPosfoer;}
    public boolean getHasJailCard() {
        return hasJailCard;
    }
    public boolean getHasPlayerCard() {
        return hasPlayerCard;
    }

    //Setters
    public void setName(String name) {
        if (name.length() == 0)
            return;
        this.name = name;
    }

    public void setHasJailCard(boolean hasJailCard) {
        this.hasJailCard = hasJailCard;
    }

    public void setHasPlayerCard(boolean hasPlayerCard){
        this.hasPlayerCard = hasPlayerCard;
    }

    public static void setPlayerNumber(int playerNumber) {
        Player.playerNumber = playerNumber;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public void setHasLost(boolean hasLost) {
        this.hasLost = hasLost;
    }

    public void setFieldPos(int fieldPos) {
        if (fieldPos < 0) {
            this.fieldPos = getFieldPos();
        } else if (fieldPos > 24) {
            while (fieldPos > 24) {
                fieldPos -= 24;
            }
            this.fieldPos = fieldPos;
        } else {
            this.fieldPos = fieldPos;
        }
        this.fieldPosfoer=this.fieldPos;
    }

    //for balance
    public void addToBalance(int amount) {
        balance.addToBalance(amount);
    }

    public void setBalance(int amount) {
        this.balance.setBalance(amount);
    }

    public int getBalance() {
        return balance.getBalance();
    }

    public void removeFromBalance(int amount) {
        this.balance.removeFromBalance(amount);
    }

}

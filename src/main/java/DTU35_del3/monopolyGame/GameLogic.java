package DTU35_del3.monopolyGame;

import DTU35_del3.board.Board;
import DTU35_del3.diceCup.DiceCup;
import DTU35_del3.player.Balance;
import DTU35_del3.player.Player;

public class GameLogic {
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private Player player4 = new Player();
    private Player[] playerList= {player1, player2, player3, player4};
    private Balance balance1, balance2, balance3, balance4;
    private DiceCup diceCup = new DiceCup();
    private Board board = new Board();
    private GUIController guiController = new GUIController();

    public void Start() {
        String[] names = guiController.startMenu();

        for (int i = 0; i < names.length; i++) {
            playerList[i].setName(names[i]);
        }


        while (true) {
            turn(player1);
            turn(player2);
        }

    }

    public void turn(Player player) {
        diceCup.rollDice();
        guiController.displayDie(diceCup.getFaceValueSum());
        int currentPos = player.getFieldPos();
        player.setFieldPos(player.getFieldPos() + diceCup.getFaceValueSum());
        guiController.movePlayer(player.getName(), currentPos, player.getFieldPos());
    }

    public void landOn(Player player) {
        switch (player1.getFieldPos()) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
            case 22:
            case 23:
                landOnStreet(player);
                break;
            case 3:
            case 9:
            case 15:
            case 21:
                landOnChance(player);
                break;
            case 18:
                landOnJail(player);
                break;

        }
    }

    public void landOnStreet(Player player) {
        int streetPrice = board.getStreetCashPrice(player.getFieldPos());
        for (Player p : playerList) {
            if (board.getOwned(player.getFieldPos()) == p.getName() && p.getName() != player.getName()) {
                player.removeFromBalance(streetPrice);

                if (!player.getHasLost()) {
                    player.addToBalance(streetPrice);
                }

            } else {
                player.removeFromBalance(streetPrice);
                board.setOwner(player.getName(), player.getFieldPos());
                guiController.buyStreet(player.getName(), player.getFieldPos());
            }
        }

    }

    public void landOnChance(Player player) {
        int cardNumber = 3;
        switch (cardNumber) {
            //Ryk frem til start. Modtag 2M
            case 1:
                guiController.movePlayer(player.getName(), player.getFieldPos(), 0);
                guiController.displayChanceCard("Ryk frem til start. Modtag 2M");
                break;


        }

    }

    public void landOnJail(Player player) {

    }


}

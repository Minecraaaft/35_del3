package DTU35_del3.monopolyGame;

import DTU35_del3.board.Board;
import DTU35_del3.diceCup.DiceCup;
import DTU35_del3.player.Balance;
import DTU35_del3.player.Player;

public class GameLogic {
    private Player[] playerList;
    private Balance balance1, balance2, balance3, balance4;
    private DiceCup diceCup = new DiceCup();
    private Board board = new Board();
    private GUIController guiController = new GUIController();

    public void Start() {
        String[] names = guiController.startMenu();

        playerList = new Player[names.length];
        for (int i = 0; i < names.length; i++) {
            playerList[i] = new Player();
            playerList[i].setName(names[i]);
        }


        while (true) {
            for (Player p : playerList) {
                turn(p);
            }
        }

    }

    public void turn(Player player) {
        diceCup.rollDice();
        guiController.DiceMenu(diceCup.getFaceValueSum(), player.getName());
        int currentPos = player.getFieldPos();
        player.setFieldPos((player.getFieldPos() + diceCup.getFaceValueSum()) % 24);
        guiController.movePlayer(player.getName(), currentPos, player.getFieldPos());
        System.out.println(player.getFieldPos());
        landOn(player);
    }

    public void landOn(Player player) {
        switch (player.getFieldPos()) {
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
                break;
            } else {
                player.removeFromBalance(streetPrice);
                guiController.updateBalance(player.getName(), player.getBalance());
                board.setOwner(player.getName(), player.getFieldPos());
                guiController.buyStreet(player.getName(), player.getFieldPos());
                System.out.println("købt");
                break;
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

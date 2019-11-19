package DTU35_del3.monopolyGame;

import DTU35_del3.board.Board;
import DTU35_del3.diceCup.DiceCup;
import DTU35_del3.player.Player;

import java.util.Random;

public class GameLogic {
    private Player[] playerList;
    private DiceCup diceCup = new DiceCup();
    private Board board = new Board();
    private GUIController guiController = new GUIController();
    private int[] chanceCards;

    public void Start() {
        //startMenu() returns a string array of names
        String[] names = guiController.startMenu();
        chanceCards = randomChanceCard();

        int startBalance = 20;

        if (names.length == 3) {
            startBalance = 18;
        } else if (names.length == 4) {
            startBalance = 16;
        }

        playerList = new Player[names.length];
        for (int i = 0; i < names.length; i++) {
            playerList[i] = new Player();
            playerList[i].setBalance(startBalance);
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

        player.setFieldPos((player.getFieldPos() + diceCup.getFaceValueSum()));
        if (player.getFieldPos() > 23) {
            player.setFieldPos(player.getFieldPos() - 24);
            player.addToBalance(2);
        }

        guiController.movePlayer(player.getName(), player.getBalance(), currentPos, player.getFieldPos());

        landOn(player);
    }

    public void landOn(Player player) {
        switch (player.getFieldPos()) {
            //these positions are all streets
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
                //these positions is chance
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
        int streetRent = board.getStreetRent(player.getFieldPos());
        int streetPrice = board.getStreetCashPrice(player.getFieldPos());

        //checks if street is owned by another player and if so pays him/her
        for (Player p : playerList) {
            if (board.getOwned(player.getFieldPos()) == p.getName() && p.getName() != player.getName()) {
                player.removeFromBalance(streetRent);

                if (!player.getHasLost()) {
                    p.addToBalance(streetRent);
                }

                guiController.updateBalance(player.getName(), player.getBalance());
                guiController.updateBalance(p.getName(), p.getBalance());
                return;
            }
        }

        //checks if the player owns the street if not the player is forced to buy it
        if (board.getOwned(player.getFieldPos()) != player.getName()) {
            player.removeFromBalance(streetPrice);
            guiController.updateBalance(player.getName(), player.getBalance());
            board.setOwner(player.getName(), player.getFieldPos());
            guiController.buyStreet(player.getName(), player.getFieldPos());
            board.checkForPairs();
            System.out.println("købt");
        }

    }

    public void landOnChance(Player player) {
        int index = 0;
        int cardNumber = chanceCards[index];

        switch (cardNumber) {
            //Bilen chance kort
            case 20:
                break;
            //Ryk frem til start. Modtag 2M
            case 1:
                guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 0);
                guiController.displayChanceCard("Ryk frem til start. Modtag 2M");
                break;
            //Ryk op til 5 felter
            case 2:

                break;
            //gratis felt (orange)
            case 3:

                break;
            //Ryk 1 frem eller tag et chance kort mere;
            case 4:

                break;
            //Skibet chance kot
            case 5:

                break;
            //Spist for meget slik
            case 6:

                break;
            //Ryk frem til orange eller grøn
            case 7:

                break;
            //Ryk frem til lyseblåt
            case 8:

                break;
            //Du løslades uden omkostninger
            case 9:

                break;
            //Ryk frem til strandpromenaden
            case 10:

                break;
            //Katten chance kort
            case 11:

                break;
            //Hunden chance kort
            case 12:

                break;
            //Fødselsdags kort
            case 13:

                break;
            //Ryk frem til punk eller mørkeblåt felt
            case 14:

                break;
            //Lavet alle dine lektier
            case 15:

                break;
            //ryk frem til et rødt felt
            case 16:

                break;
            //Ryk frem til skaterparken
            case 17:

                break;
            //ryk frem til et lyseblåt eller rødt felt
            case 18:

                break;
            //ryk frem til et brunt eller gult felt
            case 19:

                break;
        }
        index++;
        if(index == 19){
            index = 0;
        }

    }


    public void landOnJail(Player player) {

    }
    public int[] randomChanceCard() {
        //Creates a 20 long array with random numbers from 1 to 20. called "chanceArr"

        int[] chanceArr = new int[20];
        Random ran = new Random();
        boolean inArray = false;
        int counter = 0;

        while (chanceArr[19] == 0) {
            int ranNumber = ran.nextInt(21);

            for (int i = 0; i < chanceArr.length; i++) {
                if (chanceArr[i] == ranNumber) {
                    inArray = true;
                }
            }
            if (!inArray) {
                chanceArr[counter] = ranNumber;
                counter++;
            }
            inArray = false;
        }
        return chanceArr;
    }


}

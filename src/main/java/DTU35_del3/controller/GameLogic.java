package DTU35_del3.controller;

import DTU35_del3.Message;
import DTU35_del3.board.Board;
import DTU35_del3.diceCup.DiceCup;
import DTU35_del3.player.Player;

import java.util.Random;

import static DTU35_del3.Message.getMessage;

public class GameLogic {
    private Player[] playerList;
    private DiceCup diceCup = new DiceCup();
    private Board board;
    private GUIController guiController = new GUIController();
    private int[] chanceCards;
    private int index = 0;

    public void start() {
        String language = guiController.requestOption("Choose language", "danish", "english");
        new Message(language);
        board = new Board();

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

        boolean gameNotEnded = true;
        while (gameNotEnded) {
            for (Player p : playerList) {
                turn(p);
                if (p.getHasLost()) {
                    gameNotEnded = false;
                    break;
                }
            }
        }

        //find winner and losers
        Player[] playerRanking = new Player[playerList.length];

        for (Player p : playerList) {
            int position = 0;
            for (Player p2 : playerList) {
                if (p.getBalance() < p2.getBalance()) {
                    position++;
                }
            }
            playerRanking[position] = p;
        }

        String lastMsg = "";
        for (int i = 0; i < playerRanking.length; i++) {
            lastMsg = lastMsg.concat((i + 1) + ". " + playerRanking[i].getName() + "      ");

        }

        while (true) {
            guiController.showGUIMessage(lastMsg);
        }

    }

    public void turn(Player player) {
        //if in jail
        if (player.getInJail()) {
            if (player.getHasJailCard()) {
                player.setHasJailCard(false);
                guiController.showGUIMessage(player.getName() + " uses jail card.");
            } else {
                player.removeFromBalance(1);
                guiController.updateBalance(player.getName(),player.getBalance());
                if (player.getBalance() < 0) {
                    player.setHasLost(true);
                    return;
                }
                guiController.showGUIMessage(player.getName() + " pays 1M to get out of jail.");
            }
            player.setInJail(false);
        }

        if(player.getHasPlayerCard()){
            playerCard(player);
        }
        else {
            diceCup.rollDice();
            guiController.diceMenu(diceCup.getFaceValueSum(), player.getName());
            int currentPos = player.getFieldPos();

            player.setFieldPos((player.getFieldPos() + diceCup.getFaceValueSum()));
            if (player.getFieldPos() > 23) {
                player.setFieldPos(player.getFieldPos() - 24);
                player.addToBalance(2);
            }

            guiController.movePlayer(player.getName(), player.getBalance(), currentPos, player.getFieldPos());
        }
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
        int rent = board.getStreetRent(player.getFieldPos());
        int price = board.getStreetPrice(player.getFieldPos());

        //checks if street is owned by another player and if so pays him/her
        for (Player p : playerList) {
            if (board.getOwned(player.getFieldPos()) == p.getName() && p.getName() != player.getName()) {
                player.removeFromBalance(rent);
                guiController.updateBalance(player.getName(), player.getBalance());
                if (player.getBalance() < 0) {
                    player.setHasLost(true);
                    return;
                }

                p.addToBalance(rent);

                guiController.updateBalance(p.getName(), p.getBalance());
                return;
            }
        }

        //checks if the player owns the street if not the player is forced to buy it
        if (board.getOwned(player.getFieldPos()) != player.getName()) {
            player.removeFromBalance(price);
            guiController.updateBalance(player.getName(), player.getBalance());
            if (player.getBalance() < 0) {
                player.setHasLost(true);
                return;
            }

            board.setOwner(player.getName(), player.getFieldPos());
            guiController.buyStreet(player.getName(), player.getFieldPos());
            board.checkForPairs();

        }

    }

    int cardNumber = 19;
    public void landOnChance(Player player) {

        //int cardNumber = chanceCards[index];
        String field;

        switch (cardNumber) {
            //Bilen chance kort
            case 20:
                index++;
                if(index == 20){
                    index = 0;}
                landOnChance(player);
                break;
            //Ryk frem til start. Modtag 2M
            case 1:
                guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 0);
                guiController.displayChanceCard("Ryk frem til start. Modtag 2M");
                player.addToBalance(2);
                guiController.updateBalance(player.getName(), player.getBalance());
                break;
            //Ryk op til 5 felter
            case 2:
                int steps = guiController.requestInteger("Vælg hvor mange felter du vil rykke frem. max 5", 1,5);
                int placementAfter = player.getFieldPos() + steps;
                if (placementAfter > 23) {
                    placementAfter = placementAfter - 24;
                    player.addToBalance(2);
                }
                guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(),placementAfter);
                player.setFieldPos(placementAfter);

                landOn(player);
                break;
            //gratis felt (orange)
            case 3:
                field = guiController.requestOption("Hvilket orange felt vil du rykke til","SWIMMINGPOOLEN","SKATERPARKEN");
                //if player passes start
                if (player.getFieldPos() == 15 || player.getFieldPos() == 21) {
                    player.addToBalance(2);
                }

                if(field.equals("SWIMMINGPOOLEN")){

                    guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 11);
                    player.setFieldPos(11);
                    landOn(player);
                }
                else if (field.equals("SKATERPARKEN")) {
                    guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 10);
                    player.setFieldPos(10);
                    landOn(player);
                }
                break;
            //Ryk 1 frem eller tag et chance kort mere;
            case 4:
                field = guiController.requestOption("Vil du rykke 1 felt frem eller tage et chance kort mere","Ryk 1 felt frem","Tag et chance kort mere");
                if(field.equals("Ryk 1 felt frem")){
                    guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), player.getFieldPos() + 1);
                    player.setFieldPos(player.getFieldPos() + 1);
                    landOn(player);

                }
                else if (field.equals("Tag et chance kort mere")) {
                    index++;
                    if(index == 20){
                        index = 0;}
                    landOnChance(player);
                }
                break;

            //Skibet chance kot
            case 5:
                index++;
                if(index == 20){
                    index = 0;}
                landOnChance(player);

//                guiController.displayChanceCard("Du har Trukket " + playerList[0].getName() + " speciale kort og giver det til ham");
//                playerList[0].setHasPlayerCard(true);

                break;
            //Spist for meget slik
            case 6:
                guiController.showGUIMessage("Du har spist for meget slik: BETAL 2 TIL BANKEN");
                guiController.updateBalance(player.getName(),player.getBalance()-2);
                player.setBalance(player.getBalance() -2 );

                break;
            //Ryk frem til orange eller grøn
            case 7:

                field = guiController.requestOption("Hvilken farve vil du rykke frem til?","Orange","Grøn");
                if(field.equals("Orange")) {
                    if (player.getFieldPos() > 11){
                        player.addToBalance(2);
                    }
                    field = guiController.requestOption("Hvilket orange felt vil du rykke til","SWIMMINGPOOLEN","SKATERPARKEN");
                    if (field.equals("SWIMMINGPOOLEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 11);
                        player.setFieldPos(11);
                        landOn(player);
                    } else if (field.equals("SKATERPARKEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 10);
                        player.setFieldPos(10);
                        landOn(player);
                    }
                }
                else if(field.equals("Grøn")){
                    if (player.getFieldPos() > 20){
                        player.addToBalance(2);
                    }
                    field = guiController.requestOption("Hvilket grønt felt vil du rykke til","ZOO","BOWLINGHALLEN");
                    if (field.equals("ZOO")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 20);
                        player.setFieldPos(20);
                        landOn(player);
                    } else if (field.equals("BOWLINGHALLEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 19);
                        player.setFieldPos(19);
                        landOn(player);
                    }

                }
                break;
            //Ryk frem til lyseblåt
            case 8:
                field = guiController.requestOption("Hvilket Lyseblåt felt vil du rykke til","ISKIOSKEN","SLIKBUTIKKEN");
                if(field.equals("ISKIOSKEN")){
                    if (player.getFieldPos() > 5){
                        player.addToBalance(2);
                    }
                    guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 5);
                    player.setFieldPos(5);
                    landOn(player);
                }
                else if (field.equals("SLIKBUTIKKEN")) {
                    guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 4);
                    player.setFieldPos(4);
                    landOn(player);
                }

                break;
            //Du løslades uden omkostninger
            case 9:
                guiController.showGUIMessage("Du har fået et gratis \"løsladelseskort\" til næste gang du kommer i fængsel!" );
                player.setHasJailCard(true);
                break;
            //Ryk frem til strandpromenaden
            case 10:
                guiController.showGUIMessage("Du flyttes til Strandpromenaden");
                guiController.movePlayer(player.getName(), player.getBalance(),player.getFieldPos(),23);
                player.setFieldPos(23);
                landOn(player);

                break;
            //Katten chance kort
            case 11:
                index++;
                if(index == 20){
                    index = 0;}
                landOnChance(player);

                break;
            //Hunden chance kort
            case 12:
                index++;
                if(index == 20){
                    index = 0;}
                landOnChance(player);

                break;
            //Fødselsdags kort
            case 13:
                guiController.showGUIMessage("Det er din fødselsdag og alle giver dig 1 M ");
                for (int i = 0; i < playerList.length ; i++) {
                    guiController.updateBalance(playerList[i].getName(), playerList[i].getBalance() -1);
                    playerList[i].setBalance(playerList[i].getBalance() -1);
                }
                guiController.updateBalance(player.getName(),player.getBalance() + playerList.length);
                player.setBalance(playerList.length + player.getBalance());

                break;
            //Ryk frem til pink eller mørkeblåt felt
            case 14:
                field = guiController.requestOption("Hvilken farve vil du rykke frem til?","Pink","Mørkeblåt");
                if(field.equals("Pink")) {
                    if (player.getFieldPos() > 8){
                        player.addToBalance(2);
                    }
                    field = guiController.requestOption("Hvilket pink felt vil du rykke til","BIBLIOTEKET","MUSEET");
                    if (field.equals("BIBLIOTEKET")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 8);
                        player.setFieldPos(8);
                        landOn(player);
                    } else if (field.equals("MUSEET")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 7);
                        player.setFieldPos(7);
                        landOn(player);
                    }
                }
                else if(field.equals("Mørkeblåt")){

                    field = guiController.requestOption("Hvilket grønt felt vil du rykke til","STRANDPROMENADEN","VANDLANDET");
                    if (field.equals("STRANDPROMENADEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 23);
                        player.setFieldPos(23);
                        landOn(player);
                    } else if (field.equals("VANDLANDET")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 22);
                        player.setFieldPos(22);
                        landOn(player);
                    }

                }

                break;
            //Lavet alle dine lektier
            case 15:
                guiController.showGUIMessage("Du har lavet alle dine lektier og modtager derfor 2 M");
                guiController.updateBalance(player.getName(),player.getBalance()+2);
                player.setBalance(player.getBalance() +2 );

                break;
            //ryk frem til et rødt felt
            case 16:
                if (player.getFieldPos() > 14){
                    player.addToBalance(2);
                }
                field = guiController.requestOption("Hvilket Rødt felt vil du rykke til","BIOGRAFEN","SPILLEHALLEN");
                if(field.equals("BIOGRAFEN")){
                    guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 14);
                    player.setFieldPos(14);
                    landOn(player);
                }
                else if (field.equals("SPILLEHALLEN")) {
                    guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 13);
                    player.setFieldPos(13);
                    landOn(player);
                }

                break;
            //Ryk frem til skaterparken
            case 17:
                if (player.getFieldPos() > 10){
                    player.addToBalance(2);
                }
                guiController.showGUIMessage("Du flyttes til SKATERPARKEN");
                guiController.movePlayer(player.getName(), player.getBalance(),player.getFieldPos(),10);
                player.setFieldPos(10);
                landOn(player);

                break;
            //ryk frem til et lyseblåt eller rødt felt
            case 18:
                field = guiController.requestOption("Hvilken farve vil du rykke frem til?","Lyseblåt","Rødt");
                if(field.equals("Lyseblåt")) {
                    if (player.getFieldPos() > 5){
                        player.addToBalance(2);
                    }
                    field = guiController.requestOption("Hvilket pink felt vil du rykke til","ISKIOSKEN","SLIKBUTIKKEN");
                    if (field.equals("ISKIOSKEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 5);
                        player.setFieldPos(5);
                        landOn(player);
                    } else if (field.equals("SLIKBUTIKKEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 4);
                        player.setFieldPos(4);
                        landOn(player);
                    }
                }
                else if(field.equals("Rødt")){
                    if (player.getFieldPos() > 14){
                        player.addToBalance(2);
                    }
                    field = guiController.requestOption("Hvilket Rødt felt vil du rykke til","BIOGRAFEN","SPILLEHALLEN");
                    if(field.equals("BIOGRAFEN")){
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 14);
                        player.setFieldPos(14);
                        landOn(player);
                    }
                    else if (field.equals("SPILLEHALLEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 13);
                        player.setFieldPos(13);
                        landOn(player);
                    }

                }

                break;
            //ryk frem til et brunt eller gult felt
            case 19:
                field = guiController.requestOption("Hvilken farve vil du rykke frem til?","Gult","Brunt");
                if(field.equals("Gult")) {
                    if (player.getFieldPos() > 17){
                        player.addToBalance(2);
                    }
                    field = guiController.requestOption("Hvilket pink felt vil du rykke til","LEGETØJSBUTIKKEN","DYREHANDLEN");
                    if (field.equals("LEGETØJSBUTIKKEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 16);
                        player.setFieldPos(5);
                        landOn(player);
                    } else if (field.equals("DYREHANDLEN")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 17);
                        player.setFieldPos(17);
                        landOn(player);
                    }
                }
                else if(field.equals("Brunt")){
                    if (player.getFieldPos() > 2){
                        player.addToBalance(2);
                    }
                    field = guiController.requestOption("Hvilket Rødt felt vil du rykke til","PIZZARIAET","BURGERBAREN");
                    if(field.equals("BURGERBAREN")){
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 1);
                        player.setFieldPos(1);
                        landOn(player);
                    }
                    else if (field.equals("PIZZARIAET")) {
                        guiController.movePlayer(player.getName(), player.getBalance(), player.getFieldPos(), 2);
                        player.setFieldPos(2);
                        landOn(player);
                    }

                }


                break;
        }
        index++;
        if(index == 20){
            index = 0;
        }

    }


    public void landOnJail(Player player) {
        guiController.moveToJail(player.getName(), player.getFieldPos());
        player.setFieldPos(6);
        player.setInJail(true);
        guiController.showGUIMessage(player.getName() + " " + getMessage("general", 4));
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
    public void playerCard(Player player){
        String[] streets = {"Burgerbaren","Pizzeriaet","Slikbutikken","Iskiosken","Museet","Biblioteket"
                ,"Skaterparken","Swimmingpoolen","Spillehallen","Biografen","Legetøjsbutikken","Dyrehandlen","Bowlinghallen","Zoo","Vandlandet"
                ,"Strandpromenaden"};
        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;
        String field;
        for (int i = 0; i < 16 ; i++) {
            if (board.getOwned(i).equals("") );
            counter++;
        }
        String[] playerChoices = new String[counter];
        for (int i = 0; i < 16; i++) {
            if(board.getOwned(i).equals("")){
                playerChoices[counter2] = streets[i];
                counter2++;
            }
        }
        field = guiController.requestField2("vælg hvilket felt du vil rykke til", playerChoices);
        if(field.equals(streets[0])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 1);
            player.setFieldPos( 1);
            landOn(player);
        }
        else if (field.equals(streets[1])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 2);
            player.setFieldPos( 2);
            landOn(player);
        }
        else if (field.equals(streets[2])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 4);
            player.setFieldPos( 4);
            landOn(player);
        }
        else if (field.equals(streets[3])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 5);
            player.setFieldPos( 5);
            landOn(player);
        }
        else if (field.equals(streets[4])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 7);
            player.setFieldPos( 7);
            landOn(player);
        }
        else if (field.equals(streets[5])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 8);
            player.setFieldPos( 8);
            landOn(player);
        }
        else if (field.equals(streets[6])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 10);
            player.setFieldPos( 10);
            landOn(player);
        }
        else if (field.equals(streets[7])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 11);
            player.setFieldPos( 11);
            landOn(player);
        }
        else if (field.equals(streets[8])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 13);
            player.setFieldPos( 13);
            landOn(player);
        }
        else if (field.equals(streets[9])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 14);
            player.setFieldPos( 14);
            landOn(player);
        }
        else if (field.equals(streets[10])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 16);
            player.setFieldPos( 16);
            landOn(player);
        }
        else if (field.equals(streets[11])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 17);
            player.setFieldPos( 17);
            landOn(player);
        }
        else if (field.equals(streets[12])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 19);
            player.setFieldPos( 19);
            landOn(player);
        }
        else if (field.equals(streets[13])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 20);
            player.setFieldPos( 20);
            landOn(player);
        }
        else if (field.equals(streets[14])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 22);
            player.setFieldPos( 22);
            landOn(player);
        }
        else if (field.equals(streets[15])){
            guiController.movePlayer(player.getName(),player.getBalance(),player.getFieldPos(), 23);
            player.setFieldPos( 23);
            landOn(player);
        }


        player.setHasPlayerCard(false);

//        Hvad der stadig mangler list:
//        hvis alle felter er optaget
//        at trække nyt kort efter man har fået spiller kort
//        de andre spillers kort
//        hvis der kun er 2 og 3 spillere.
//        med 2 spillere kan man ikke trykke vidre når spiller 2 lander på nr.2 chancekort???
//
//
//
//
    }


}

package DTU35_del3.board;

public class Board {
    private Message message;
    private Street[] Streets = new Street[11];
    public Board(String language) {
        message = new Message(language);

        Streets[0] = new Street("Start", message.towerMessage(), 250, 0);
        Streets[1] = new Street("Crater", message.craterMessage(), -100, 1);
        Streets[2] = new Street("Palace gates", message.palaceGatesMessage(), 100, 2);
        Streets[3] = new Street("Cold Desert", message.coldDesertMessage(), -20, 3);
        Streets[4] = new Street("Walled city", message.walledCityMessage(), 180, 4);
        Streets[5] = new Street("Monastery", message.monasteryMessage(), 0, 5);
        Streets[6] = new Street("Black cave", message.blackCaveMessage(), -70, 6);
        Streets[7] = new Street("Huts in the mountain", message.hutsInTheMountainMessage(), 60, 7);
        Streets[8] = new Street("The Werewall (werewolf-wall)", message.theWerewallMessage(), -80, 8);
        Streets[9] = new Street("The pit", message.thePitMessage(), -50, 9);
        Streets[10] = new Street("Goldmine", message.goldmineMessage(), 650, 10);
    }

    public String getStreetName(int StreetNumber) {
        String name = Streets[StreetNumber].getName();
        return name;
    }

    public int getStreetNumber(String StreetName) {
        int StreetNumber = 404;
        for (Street a: Streets) {
            if (StreetName == a.getName()) {
                StreetNumber = a.getStreetNumber();
            }
        }
        return StreetNumber;
    }

    public String getStreetMessage(int StreetNumber) {
        String message = Streets[StreetNumber].getMessage();
        return message;
    }

    public String getStreetMessage(String StreetName) {
        String message = "";
        for (Street a: Streets) {
            if (StreetName == a.getName()) {
                message = a.getMessage();
            }
        }
        return message;
    }

    public int getStreetCashPrize(int StreetNumber) {
        int cash = Streets[StreetNumber].getCashPrize();
        return cash;
    }

    public int getStreetCashPrize(String StreetName) {
        int cash = 404;
        for (Street a: Streets) {
            if (StreetName == a.getName()) {
                cash = a.getCashPrize();
            }
        }
        return cash;
    }


}
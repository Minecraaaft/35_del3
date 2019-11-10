package DTU35_del3.board;

public class Board {
    private Message message;
    private Square[] Squares = new Square[11];
    public Board(String language) {
        message = new Message(language);

        Squares[0] = new Square("Tower", message.towerMessage(), 250, 0);
        Squares[1] = new Square("Crater", message.craterMessage(), -100, 1);
        Squares[2] = new Square("Palace gates", message.palaceGatesMessage(), 100, 2);
        Squares[3] = new Square("Cold Desert", message.coldDesertMessage(), -20, 3);
        Squares[4] = new Square("Walled city", message.walledCityMessage(), 180, 4);
        Squares[5] = new Square("Monastery", message.monasteryMessage(), 0, 5);
        Squares[6] = new Square("Black cave", message.blackCaveMessage(), -70, 6);
        Squares[7] = new Square("Huts in the mountain", message.hutsInTheMountainMessage(), 60, 7);
        Squares[8] = new Square("The Werewall (werewolf-wall)", message.theWerewallMessage(), -80, 8);
        Squares[9] = new Square("The pit", message.thePitMessage(), -50, 9);
        Squares[10] = new Square("Goldmine", message.goldmineMessage(), 650, 10);
    }

    public String getSquareName(int SquareNumber) {
        String name = Squares[SquareNumber].getName();
        return name;
    }

    public int getSquareNumber(String SquareName) {
        int SquareNumber = 404;
        for (Square a: Squares) {
            if (SquareName == a.getName()) {
                SquareNumber = a.getSquareNumber();
            }
        }
        return SquareNumber;
    }

    public String getSquareMessage(int SquareNumber) {
        String message = Squares[SquareNumber].getMessage();
        return message;
    }

    public String getSquareMessage(String SquareName) {
        String message = "";
        for (Square a: Squares) {
            if (SquareName == a.getName()) {
                message = a.getMessage();
            }
        }
        return message;
    }

    public int getSquareCashPrize(int SquareNumber) {
        int cash = Squares[SquareNumber].getCashPrize();
        return cash;
    }

    public int getSquareCashPrize(String SquareName) {
        int cash = 404;
        for (Square a: Squares) {
            if (SquareName == a.getName()) {
                cash = a.getCashPrize();
            }
        }
        return cash;
    }


}
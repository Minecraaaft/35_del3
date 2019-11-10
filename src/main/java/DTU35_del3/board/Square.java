package DTU35_del3.board;

public class Square {
    private String name;
    private String message;
    private int cashPrize;
    private int SquareNumber;

    public Square(String name, String message, int cashPrize, int SquareNumber) {
        this.name = name;
        this.message = message;
        this.cashPrize = cashPrize;
        this.SquareNumber = SquareNumber;
    }

    public String getName() {
        return name;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public String getMessage() {
        return message;
    }

    public int getSquareNumber() {
        return SquareNumber;
    }
}
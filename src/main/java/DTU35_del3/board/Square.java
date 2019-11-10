package DTU35_del3.board;

public class Street {
    private String name;
    private String message;
    private int cashPrize;
    private int StreetNumber;

    public Street(String name, String message, int cashPrize, int StreetNumber) {
        this.name = name;
        this.message = message;
        this.cashPrize = cashPrize;
        this.StreetNumber = StreetNumber;
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

    public int getStreetNumber() {
        return StreetNumber;
    }
}
package DTU35_del3.board;

public class Street {
    private String name;
//    private String message;
    private int cashPrice;
    private int StreetNumber;
    private String StreetColor;

    public Street(String name,String StreetColor, int cashPrice, int StreetNumber) {
        this.name = name;
//        this.message = message;
        this.cashPrice = cashPrice;
        this.StreetNumber = StreetNumber;
        this.StreetColor = StreetColor;
    }

    public String getStreetColor() {
        return StreetColor;
    }

    public String getName() {
        return name;
    }

    public int getCashPrice() {
        return cashPrice;
    }

//    public String getMessage() {
//        return message;
//    }

    public int getStreetNumber() {
        return StreetNumber;
    }
}
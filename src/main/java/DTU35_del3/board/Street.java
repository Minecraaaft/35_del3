package DTU35_del3.board;

public class Street {
    private String name;
//    private String message;
    private int cashPrice;
    private int streetNumber;
    private String streetColor;

    public Street(String name,String streetColor, int cashPrice, int streetNumber) {
        this.name = name;
//        this.message = message;
        this.cashPrice = cashPrice;
        this.streetNumber = streetNumber;
        this.streetColor = streetColor;
    }

    public String getStreetColor() {
        return streetColor;
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
        return streetNumber;
    }

    public java.lang.String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", cashPrice=" + cashPrice +
                ", streetNumber=" + streetNumber +
                ", streetColor='" + streetColor + '\'' +
                '}';
    }
}
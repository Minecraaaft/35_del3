package DTU35_del3.board;

public class Street {
    private String name;
//    private String message;
    private int streetPrice;
    private int streetNumber;
    private String streetColor;
    private int streetRent;

    public Street(String name, String streetColor, int streetPrice, int streetNumber, int streetRent) {
        this.name = name;
//        this.message = message;
        this.streetPrice = streetPrice;
        this.streetNumber = streetNumber;
        this.streetColor = streetColor;
        this.streetRent = streetRent;
    }

    public String getStreetColor() {
        return streetColor;
    }

    public String getName() {
        return name;
    }

    public int getStreetPrice() {
        return streetPrice;
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
                ", streetPrice=" + streetPrice +
                ", streetNumber=" + streetNumber +
                ", streetColor='" + streetColor + '\'' +
                '}';
    }
}
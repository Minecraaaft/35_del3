package DTU35_del3.board;

public class Street {
    private String name;
    private int price;
    private int streetNumber;
    private boolean paired;
    private String color;
    private int rent;
    private String ownedBy = "";

    public Street(String name, String color, int price, int streetNumber, int rent) {
        this.name = name;
        this.price = price;
        this.streetNumber = streetNumber;
        this.color = color;
        this.rent = rent;
    }
    //getters
    public String getcolor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getOwned() {
        return this.ownedBy;
    }

    public boolean isPaired() {
        return paired;
    }


    //setters
    public void setPaired(boolean paired) {
        this.paired = paired;
        this.rent = this.price * 2;
    }

    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }
}
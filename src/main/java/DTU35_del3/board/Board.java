package DTU35_del3.board;

import java.util.Arrays;

import static DTU35_del3.Message.getMessage;

public class Board {

    private Street[] Streets = new Street[16];
    public Board() {
        Streets[0] = new Street(getMessage("board names", 1), "brown", 1, 1,1);
        Streets[1] = new Street(getMessage("board names", 2), "brown",1, 2,1);
        Streets[2] = new Street(getMessage("board names", 4), "lightblue",1, 4,1);
        Streets[3] = new Street(getMessage("board names", 5), "lightblue",1, 5,1);
        Streets[4] = new Street(getMessage("board names", 7), "pink",2, 7,2);
        Streets[5] = new Street(getMessage("board names", 8), "pink",2, 8,2);
        Streets[6] = new Street(getMessage("board names", 10),"orange",2, 10,2);
        Streets[7] = new Street(getMessage("board names", 11), "orange",2, 11,2);
        Streets[8] = new Street(getMessage("board names", 13),"red",3, 13,3);
        Streets[9] = new Street(getMessage("board names", 14), "red", 3, 14,3);
        Streets[10] = new Street(getMessage("board names", 16), "yellow",3, 16,3);
        Streets[11] = new Street(getMessage("board names", 17), "yellow",3, 17, 3);
        Streets[12] = new Street(getMessage("board names", 19), "green",4, 19,4);
        Streets[13] = new Street(getMessage("board names", 20), "green",4, 20,4);
        Streets[14] = new Street(getMessage("board names", 22), "blue",5, 22,5);
        Streets[15] = new Street(getMessage("board names", 23), "blue",5, 23,5);
    }

    public void checkForPairs() {
        for (int i = 0; i < 9; i+=2) {
            if (Streets[i].getOwned() == Streets[i+1].getOwned() && Streets[i].getOwned() != "") {
                Streets[i].setPaired(true);
                Streets[i+1].setPaired(true);
            }
        }
    }

    public boolean isPaired(int streetNumber) {
        boolean isPaired = false;
        for (Street s : Streets) {
            if (streetNumber == s.getStreetNumber()) {
                isPaired = s.isPaired();
            }
        }
        return isPaired;
    }


    public int getStreetNumber(String streetName) {
        int streetNumber = 404;
        for (Street a: Streets) {
            if (streetName.equals(a.getName())) {
                streetNumber = a.getStreetNumber();
            }
        }
        return streetNumber;
    }

    //Returns an empty string that if it has no player assigned to it
    public String getOwned(int pos) {
        String ownedBy = "";
        for (Street s : Streets) {
            if (pos == s.getStreetNumber()) {
                ownedBy = s.getOwned();
            }
        }

        return ownedBy;
    }

    public void setOwner(String name, int pos) {
        for (Street s : Streets) {
            if (pos == s.getStreetNumber()) {
                s.setOwnedBy(name);
            }
        }
    }


    public String getColor(int streetNumber) {
        String color ="";
        for (Street s : Streets) {
            if (streetNumber == s.getStreetNumber()) {
                color = s.getcolor();
            }
        }
        return color;
    }

    public int getStreetCashPrice(int streetNumber) {
        int price=0;
        for (Street s : Streets) {
            if (streetNumber == s.getStreetNumber()) {
                price = s.getPrice();
            }
        }
        return price;
    }

    public int getrent(int streetNumber) {
        int price=0;
        for (Street s : Streets) {
            if (streetNumber == s.getStreetNumber()) {
                price = s.getRent();
            }
        }
        return price;
    }

    public int getStreetCashPrice(String streetName) {
        int cash = 404;
        for (Street a: Streets) {
            if (streetName.equals(a.getName())) {
                cash = a.getPrice();
            }
        }
        return cash;
    }

}
package DTU35_del3.board;

import java.util.Arrays;

public class Board {
//    private Message message;
    private Street[] Streets = new Street[16];
    public Board() {
//        message = new Message(language);

        Streets[0] = new Street("Burgerbaren", "brown", 1, 1,1);
        Streets[1] = new Street("Pizzeriaet", "brown",1, 2,1);
        Streets[2] = new Street("Slikbutikken", "lightblue",1, 4,1);
        Streets[3] = new Street("Iskiosken", "lightblue",1, 5,1);
        Streets[4] = new Street("Museet", "pink",2, 7,2);
        Streets[5] = new Street("Biblioteket", "pink",2, 8,2);
        Streets[6] = new Street("Skaterparken","orange",2, 10,2);
        Streets[7] = new Street("Swimmingpoolen", "orange",2, 11,2);
        Streets[8] = new Street("Spillehallen","red",3, 13,3);
        Streets[9] = new Street("Biografen", "red", 3, 14,3);
        Streets[10] = new Street("Legetøjsbutikken", "yellow",3, 16,3);
        Streets[11] = new Street("Dyrehandlen", "yellow",3, 17, 3);
        Streets[12] = new Street("Bowlinghallen", "green",4, 19,4);
        Streets[13] = new Street("Zoo", "green",4, 20,4);
        Streets[14] = new Street("Vandlandet", "blue",5, 22,4);
        Streets[15] = new Street("Strandpromenaden", "blue",5, 23,4);
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

//    public String getStreetName(int streetNumber) {
//        return Streets[streetNumber].getName();
//    }

    public int getStreetNumber(String streetName) {
        int streetNumber = 404;
        for (Street a: Streets) {
            if (streetName.equals(a.getName())) {
                streetNumber = a.getStreetNumber();
            }
        }
        return streetNumber;
    }

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
                s.setOwned(name);
            }
        }
    }


    public String getStreetColor(int streetNumber) {
        String color ="";
        for (Street s : Streets) {
            if (streetNumber == s.getStreetNumber()) {
                color = s.getStreetColor();
            }
        }
        return color;
    }

    public int getStreetCashPrice(int streetNumber) {
        int price=0;
        for (Street s : Streets) {
            if (streetNumber == s.getStreetNumber()) {
                price = s.getStreetPrice();
            }
        }
        return price;
    }

    public int getStreetRent(int streetNumber) {
        int price=0;
        for (Street s : Streets) {
            if (streetNumber == s.getStreetNumber()) {
                price = s.getStreetRent();
            }
        }
        return price;
    }

    public int getStreetCashPrice(String streetName) {
        int cash = 404;
        for (Street a: Streets) {
            if (streetName.equals(a.getName())) {
                cash = a.getStreetPrice();
            }
        }
        return cash;
    }

    @Override
    public String toString() {
        return "Board{" +
                "Streets=" + Arrays.toString(Streets) +
                '}';
    }
}
package DTU35_del3.board;

import static DTU35_del3.Message.getMessage;

public class Board {

    private Street[] Streets = new Street[16];
    public Board() {
        Streets[0] = new Street("Burgerbaren", "brown", 1, 1,1);
        Streets[1] = new Street("Pizzariaet", "brown",1, 2,1);
        Streets[2] = new Street("Slikbutikken", "lightblue",1, 4,1);
        Streets[3] = new Street("Isbutikken", "lightblue",1, 5,1);
        Streets[4] = new Street("Museet", "pink",2, 7,2);
        Streets[5] = new Street("Biblioteket", "pink",2, 8,2);
        Streets[6] = new Street("Skaterparken","orange",2, 10,2);
        Streets[7] = new Street("Svømmehallen", "orange",2, 11,2);
        Streets[8] = new Street("Spillehallen","red",3, 13,3);
        Streets[9] = new Street("Biografen", "red", 3, 14,3);
        Streets[10] = new Street("Legetøjsbutik", "yellow",3, 16,3);
        Streets[11] = new Street("Dyrehandlen", "yellow",3, 17, 3);
        Streets[12] = new Street("Bowlinghallen", "green",4, 19,4);
        Streets[13] = new Street("Zoo", "green",4, 20,4);
        Streets[14] = new Street("Vandlandet", "blue",5, 22,5);
        Streets[15] = new Street("Strand", "blue",5, 23,5);
    }

    public void checkForPairs() {
        for (int i = 0; i < 9; i+=2) {
            if (Streets[i].getOwned().equals(Streets[i + 1].getOwned()) && !Streets[i].getOwned().equals("")) {
                Streets[i].setPaired(true);
                Streets[i+1].setPaired(true);
            }
        }
    }

    public int getStreetPrice(int pos) {
        int price=0;
        for (Street s : Streets) {
            if (pos == s.getStreetNumber()) {
                price = s.getPrice();
            }
        }
        return price;
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

    public int getStreetRent(int pos) {
        int price=0;
        for (Street s : Streets) {
            if (pos == s.getStreetNumber()) {
                price = s.getRent();
            }
        }
        return price;
    }

    public void setOwner(String name, int pos) {
        for (Street s : Streets) {
            if (pos == s.getStreetNumber()) {
                s.setOwnedBy(name);
            }
        }
    }




}
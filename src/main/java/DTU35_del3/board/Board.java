package DTU35_del3.board;

import java.util.Arrays;

public class Board {
//    private Message message;
    private Street[] Streets = new Street[16];
    public Board() {
//        message = new Message(language);

        Streets[0] = new Street("Burgerbaren", "brown", -1, 0,-1);
        Streets[1] = new Street("Pizzeriaet", "brown",-1, 1,-1);
        Streets[2] = new Street("Slikbutikken", "lightblue",-1, 2,-1);
        Streets[3] = new Street("Iskiosken", "lightblue",-1, 3,-1);
        Streets[4] = new Street("Museet", "pink",-2, 4,-2);
        Streets[5] = new Street("Biblioteket", "pink",-2, 5,-2);
        Streets[6] = new Street("Skaterparken","orange",-2, 6,-2);
        Streets[7] = new Street("Swimmingpoolen", "orange",-2, 7,-2);
        Streets[8] = new Street("Spillehallen","red",-3, 8,-3);
        Streets[9] = new Street("Biografen", "red", -3, 9,-3);
        Streets[10] = new Street("Legetøjsbutikken", "yellow",-3, 10,-3);
        Streets[11] = new Street("Dyrehandlen", "yellow",-3, 11, -3);
        Streets[12] = new Street("Bowlinghallen", "green",-4, 12,-4);
        Streets[13] = new Street("Zoo", "green",-4, 13,-4);
        Streets[14] = new Street("Vandlandet", "blue",-5, 14,-5);
        Streets[15] = new Street("Strandpromenaden", "blue",-5, 15,-5);
    }

    public String getStreetName(int streetNumber) {
        return Streets[streetNumber].getName();
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

//    public String getStreetMessage(int streetNumber) {
//        String message = Streets[streetNumber].getMessage();
//        return message;
//    }

//    public String getStreetMessage(String StreetName) {
//        String message = "";
//        for (Street a: Streets) {
//            if (StreetName == a.getName()) {
//                message = a.getMessage();
//            }
//        }
//        return message;
//    }

    public String getStreetColor(int streetNumber){
        return Streets[streetNumber].getStreetColor();
    }

    public int getStreetCashPrice(int streetNumber) {
        return Streets[streetNumber].getStreetPrice();
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
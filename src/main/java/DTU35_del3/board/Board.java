package DTU35_del3.board;

import java.util.Arrays;

public class Board {
//    private Message message;
    private Street[] Streets = new Street[16];
    public Board() {
//        message = new Message(language);

        Streets[0] = new Street("Burgerbaren", "brown", -1, 0);
        Streets[1] = new Street("Pizzeriaet", "brown",-1, 1);
        Streets[2] = new Street("Slikbutikken", "lightblue",-1, 2);
        Streets[3] = new Street("Iskiosken", "lightblue",-1, 3);
        Streets[4] = new Street("Museet", "pink",-2, 4);
        Streets[5] = new Street("Biblioteket", "pink",-2, 5);
        Streets[6] = new Street("Skaterparken","orange",-2, 6);
        Streets[7] = new Street("Swimmingpoolen", "orange",-2, 7);
        Streets[8] = new Street("Spillehallen","red",-3, 8);
        Streets[9] = new Street("Biografen", "red", -3, 9);
        Streets[10] = new Street("Legetøjsbutikken", "yellow",-3, 10);
        Streets[11] = new Street("Dyrehandlen", "yellow",-3, 11);
        Streets[12] = new Street("Bowlinghallen", "green",-4, 12);
        Streets[13] = new Street("Zoo", "green",-4, 13);
        Streets[14] = new Street("Vandlandet", "blue",-5, 14);
        Streets[15] = new Street("Strandpromenaden", "blue",-5, 15);
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

    public int getStreetCashPrice(int streetNumber) {
        return Streets[streetNumber].getCashPrice();
    }

    public int getStreetCashPrice(String streetName) {
        int cash = 404;
        for (Street a: Streets) {
            if (streetName.equals(a.getName())) {
                cash = a.getCashPrice();
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
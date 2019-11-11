package DTU35_del3.board;

import java.util.Arrays;

public class Board {
//    private Message message;
    private Street[] Streets = new Street[22];
    public Board() {
//    message = new Message(language);

        Streets[0] = new Street("Rødovrevej", "blue", -60, 0,-60);
        Streets[1] = new Street("Hvidovrevej", "blue",-60, 1,-60);
        Streets[2] = new Street("Roskildevej", "pink",-100, 2,-100);
        Streets[3] = new Street("Valby Langgade", "pink",-100, 3,-100);
        Streets[4] = new Street("Allégade", "pink",-120, 4,-120);
        Streets[5] = new Street("Frederiksberg Allé", "green",-140, 5,-140);
        Streets[6] = new Street("Bülowsvej","green",-140, 6,-140);
        Streets[7] = new Street("Gammel Kongevej", "green",-140, 7,-140);
        Streets[8] = new Street("Bernstorffsvej","gray",-180, 8,-180);
        Streets[9] = new Street("Hellerupvej", "gray", -180, 9,-180);
        Streets[10] = new Street("Strandvejen", "gray",-180, 10,-180);
        Streets[11] = new Street("Trianglen", "red",-220, 11, -220);
        Streets[12] = new Street("Østerbrogade", "red",-220, 12,-220);
        Streets[13] = new Street("Grønningen", "red",-240, 13,-240);
        Streets[14] = new Street("Bredgade", "hvid",-260, 14,-260);
        Streets[15] = new Street("Kgs. Nytorv", "hvid",-260, 15,-260);
        Streets[16] = new Street("Østergade", "hvid",-280, 16,-280);
        Streets[17] = new Street("Amagertorv", "gul",-300, 17,-300);
        Streets[18] = new Street("Vimmelskaftet", "gul",-300, 18,-300);
        Streets[19] = new Street("Nygade", "gul",-320, 19,-320);
        Streets[20] = new Street("Frederiksberggade", "lilla",-350, 20,-350);
        Streets[21] = new Street("Rådhuspladsen", "lilla",-400, 21,-400);
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
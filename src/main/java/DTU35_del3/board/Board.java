package DTU35_del3.board;

public class Board {
//    private Message message;
    private Street[] Streets = new Street[14];
    public Board() {
//        message = new Message(language);

        Streets[0] = new Street("Burgerbaren", -1, 0);
        Streets[1] = new Street("Pizzeriaet", -1, 1);
        Streets[2] = new Street("Slikbutikken", -1, 2);
        Streets[3] = new Street("Iskiosken",-1, 3);
        Streets[4] = new Street("Museet",-2, 4);
        Streets[5] = new Street("Biblioteket",-2, 5);
        Streets[6] = new Street("Skaterparken",-2, 6);
        Streets[7] = new Street("Swimmingpoolen",-2, 7);
        Streets[8] = new Street("Spillehallen",-3, 8);
        Streets[9] = new Street("Biografen",-3, 9);
        Streets[10] = new Street("Legetøjsbutikken",-3, 10);
        Streets[11] = new Street("Dyrehandlen",-3, 11);
        Streets[12] = new Street("Bowlinghallen",-4, 12);
        Streets[13] = new Street("Zoo",-4, 13);
        Streets[14] = new Street("Vandlandet", -5, 14);
        Streets[15] = new Street("Strandpromenaden",-5, 15);
    }

    public String getStreetName(int StreetNumber) {
        String name = Streets[StreetNumber].getName();
        return name;
    }

    public int getStreetNumber(String StreetName) {
        int StreetNumber = 404;
        for (Street a: Streets) {
            if (StreetName == a.getName()) {
                StreetNumber = a.getStreetNumber();
            }
        }
        return StreetNumber;
    }

//    public String getStreetMessage(int StreetNumber) {
//        String message = Streets[StreetNumber].getMessage();
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

    public int getStreetCashPrice(int StreetNumber) {
        int cash = Streets[StreetNumber].getCashPrice();
        return cash;
    }

    public int getStreetCashPrice(String StreetName) {
        int cash = 404;
        for (Street a: Streets) {
            if (StreetName == a.getName()) {
                cash = a.getCashPrice();
            }
        }
        return cash;
    }


}
package DTU35_del3.monopolyGame;

import java.util.Random;

public class MonopolyGame {



    //Creates a 20 long array with random numbers from 1 to 20. called "chanceArr"
    int[] chanceArr = new int[20];
    Random ran = new Random();
    boolean inArray = false;
    int counter = 0;

        while (chanceArr[19] == 0) {
        int ranNumber = ran.nextInt(21);

        for (int i = 0; i < chanceArr.length; i++) {
            if (chanceArr[i] == ranNumber) {
                inArray = true;
            }
        }
        if (!inArray) {
            chanceArr[counter] = ranNumber;
            counter++;
        }
        inArray = false;
    }
}




}

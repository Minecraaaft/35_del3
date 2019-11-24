package test;

import DTU35_del3.diceCup.DiceCup;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiceCupTest {

    DiceCup myTestDicecup = new DiceCup(new DieStubClass());


    //JUnit test of rollDice and rollDiceOutcome
    @Test
    public void rollDice() {
        for (int i = 0; i < 10000; i++) {
            assertEquals(3.5, myTestDicecup.rollDice(), 2.5);
        }
    }

    @Test
    public void rollDiceOutcome() {
        int[] arr = new int[6];

        for (int i = 0; i < 36000; i++) {
            int value = myTestDicecup.rollDice();
            switch (value) {
                case 1:
                    arr[0]++;
                    break;
                case 2:
                    arr[1]++;
                    break;
                case 3:
                    arr[2]++;
                    break;
                case 4:
                    arr[3]++;
                    break;
                case 5:
                    arr[4]++;
                    break;
                case 6:
                    arr[5]++;
                    break;

            }
        }
        assertEquals(1/36.*36000, arr[0], 1/6.*36000);
        assertEquals(2/36.*36000, arr[1], 1/6.*36000);
        assertEquals(3/36.*36000, arr[2], 1/6.*36000);
        assertEquals(4/36.*36000, arr[3], 1/6.*36000);
        assertEquals(5/36.*36000, arr[4], 1/6.*36000);
        assertEquals(6/36.*36000, arr[5], 1/6.*36000);

    }

}
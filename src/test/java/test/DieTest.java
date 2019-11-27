package test;

import DTU35_del3.diceCup.Die;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DieTest {
    int nsides = 6; //sides on die

    @org.junit.Test
    //This test will test if the rolls are between 1 and nsides in 1000000 rolls
    public void rollOutside() {
        Die d1 = new Die(nsides);

        for (int i = 0; i < 1000000; i++) {
            assertEquals(nsides / 2. + 0.5, d1.roll(), nsides / 2. - 0.5);
        }
    }

    @org.junit.Test
    /* This test will test the probability of rolling the numbers 1-6 and compares it
       to the statistic value for 600000 rolls with one dice */
    public void rollInside() {
        Die d1 = new Die(6);
        float roll1 = 0F, roll2 = 0F, roll3 = 0F, roll4 = 0F, roll5 = 0F, roll6 = 0F;
        int antalRolls = 0;
        //            float array[] = {roll1,roll2,roll3,roll4,roll5,roll6};

        for (int i = 1; i < 600001; i++) {
            switch (d1.roll()) {
                case 1:
                    roll1++;
//                    array[0]++;
                    break;
                case 2:
                    roll2++;
//                    array[1]++;
                    break;
                case 3:
                    roll3++;
//                    array[2]++;
                    break;
                case 4:
                    roll4++;
//                    array[3]++;
                    break;
                case 5:
                    roll5++;
//                    array[4]++;
                    break;
                case 6:
                    roll6++;
//                    array[5]++;
                    break;
            }
            antalRolls++;


        }
        assertEquals(antalRolls / 6., roll1, 1/150.*antalRolls);
        assertEquals(antalRolls / 6., roll2, 1/150.*antalRolls);
        assertEquals(antalRolls / 6., roll3, 1/150.*antalRolls);
        assertEquals(antalRolls / 6., roll4, 1/150.*antalRolls);
        assertEquals(antalRolls / 6., roll5, 1/150.*antalRolls);
        assertEquals(antalRolls / 6., roll6, 1/150.*antalRolls);
//        System.out.println("Number of 1's rolled: " + roll1 + ". The expected number is: " + (antalRolls / 6.) +
//                " with the difference being " + Math.abs((antalRolls / 6. - roll1)) +
//                ". This is less than the expected difference of " + 1/150.*antalRolls);
//
//        System.out.println("Number of 2's rolled: " + roll2 + ". The expected number is: " + (antalRolls / 6.) +
//                " with the difference being " + Math.abs((antalRolls / 6. - roll2)) +
//                ". This is less than the expected difference of " + 1/150.*antalRolls);
//
//        System.out.println("Number of 3's rolled: " + roll3 + ". The expected number is: " + (antalRolls / 6.) +
//                " with the difference being " + Math.abs((antalRolls / 6. - roll3)) +
//                ". This is less than the expected difference of " + 1/150.*antalRolls);
//
//        System.out.println("Number of 4's rolled: " + roll4 + ". The expected number is: " + (antalRolls / 6.) +
//                " with the difference being " + Math.abs((antalRolls / 6. - roll4)) +
//                ". This is less than the expected difference of " + 1/150.*antalRolls);
//
//        System.out.println("Number of 5's rolled: " + roll5 + ". The expected number is: " + (antalRolls / 6.) +
//                " with the difference being " + Math.abs((antalRolls / 6. - roll5)) +
//                ". This is less than the expected difference of " + 1/150.*antalRolls);
//
//        System.out.println("Number of 6's rolled: " + roll6 + ". The expected number is: " + (antalRolls / 6.) +
//                " with the difference being " + Math.abs((antalRolls / 6. - roll6)) +
//                ". This is less than the expected difference of " + 1/150.*antalRolls);


    }
}
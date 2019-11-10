package DTU35_del3.diceCup;

import java.util.Random;

public class Die {
    // Attributes
    private int faceValue;
    private int sides;

    // Constructor
    public Die(int sides) { this.sides = sides; }

    // generating a number from 1-sides and returning it
    // Go to DiceCup.java to determine number of sides of the die.
    public int roll() {
        Random random = new Random();
        faceValue = random.nextInt(sides)+1;
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

}

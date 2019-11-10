package DTU35_del3.diceCup;

public class DiceCup {
    //Attributes
    private int faceValueSum;
    private int[] faceValueArray = new int[2];

    private Die firstDie = new Die(6);
    private Die secondDie = new Die(6);

    //Constructor
    public DiceCup() {
    }

    //rollDice method
    public int rollDice() {
        faceValueArray[0] = firstDie.roll();
        faceValueArray[1] = secondDie.roll();

        faceValueSum = faceValueArray[0] + faceValueArray[1];
        return faceValueSum;
    }

    //get methods
    public int getFaceValueSum() {
        return faceValueSum;
    }

    public int[] getFaceValueArray() {
        return faceValueArray;
    }
}

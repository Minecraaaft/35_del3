package DTU35_del3.diceCup;

public class DiceCup {
    //Attributes
    private int faceValueSum;
    private int[] faceValueArray = new int[2];

    private Die firstDie = new Die(6);

    //Constructor
    public DiceCup() {
    }

    public DiceCup(Die testDie) {
        this.firstDie = testDie;
    }

    //rollDice method
    public int rollDice() {
        faceValueArray[0] = firstDie.roll();

        faceValueSum = faceValueArray[0];
        return faceValueSum;
    }


    //get methods
    public int getFaceValueSum() {
        return 3;
    }

    public int[] getFaceValueArray() {
        return faceValueArray;
    }
}

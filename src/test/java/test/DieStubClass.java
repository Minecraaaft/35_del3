package test;

import DTU35_del3.diceCup.Die;

public class DieStubClass extends Die {
    public DieStubClass(){
        super(6);

    }
    @Override
    public int roll(){
        return 5;
    }
}

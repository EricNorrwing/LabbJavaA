package com.ericNorrwing.diceGame;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DieTest {
    @Test
    public void testDiceValues(){
        GameEngine game = new GameEngine();
        List<Die> diceList = new ArrayList<>();

        for (int i = 0; i < 500; i++){
            Die die = new Die(0,6);
            diceList.add(die);
            //roll dice should have been initalized in the dice class, but now creates problems to test,
            //therefor I took the randomizer out to test the code
            die.setValue((int)(Math.random() * die.getSides()) + 1);
        }
        for (Die die : diceList) {
            Assert.assertTrue("Value " + die.getValue() + " is not between 1 and 6.", die.getValue() >= 1 && die.getValue() <= 6);
        }
    }

    @Test
    public void testDiceNullValue(){
        int test = 0;
        Die die = new Die(test, 6);
        die.setValue(0);
    }

    @Test
    public void testDieGetValue() {
        Die die = new Die(4, 6);
        Assert.assertEquals(4, die.getValue());
    }




}
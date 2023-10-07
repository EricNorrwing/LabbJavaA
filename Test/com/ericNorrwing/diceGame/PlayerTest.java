package com.ericNorrwing.diceGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private Player player;
    @Before
    public void setUp() {
        player = new Player("Krillinator jag pajade min kod", 500, 1, 15);
    }
    
    @Test
    public void testCreatePlayer(){

        Assert.assertEquals("Krillinator jag pajade min kod", player.getName());

    }
}

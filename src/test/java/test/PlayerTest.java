package test;

import DTU35_del3.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        Player.setPlayerNumber(0);

        Player p1 = new Player();
        Player p2 = new Player();

        assertEquals("Player 1",p1.getName());
        assertEquals("Player 2",p2.getName());
    }

    @Test
    public void setName() {
        Player p1 = new Player();
        p1.setName("testName");
        assertEquals("testName", p1.getName());
    }

    @Test
    public void setHasWon() {
        Player p1 = new Player();
        p1.setHasWon(true);
        assertTrue(p1.getHasWon());
    }

    @Test
    public void setFieldPos() {
        Player p1 = new Player();
        p1.setFieldPos(4);
        assertEquals(4,p1.getFieldPos());
    }
}
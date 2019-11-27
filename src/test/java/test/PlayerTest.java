package test;

import DTU35_del3.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getHasLost() {
        Player p1 = new Player();
        p1.setHasLost(true);
        assertTrue(p1.getHasLost());
    }

    @Test
    public void getFieldPos() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Player p4 = new Player();
        p1.setFieldPos(26);
        p2.setFieldPos(7);
        p3.setFieldPos(-3);
        p4.setFieldPos(100);

        assertEquals(2,p1.getFieldPos());
        assertEquals(7,p2.getFieldPos());
        assertEquals(0,p3.getFieldPos());
        assertEquals(4,p4.getFieldPos());

    }

    @Test
    public void getName() {
        Player.setPlayerNumber(0);
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.setName("Bob");
        p2.setName("Johnny");
        p3.setName("");

        assertEquals("Bob",p1.getName());
        assertEquals("Johnny",p2.getName());
        assertEquals("Player 3",p3.getName());

    }

    @Test
    public void getInJail() {
        Player p1 = new Player();
        p1.setInJail(true);
        assertTrue(p1.getInJail());
    }

    @Test
    public void getHasJailCard() {
        Player p1 = new Player();
        p1.setHasJailCard(true);
        assertTrue(p1.getHasJailCard());
    }

    //probably not useful when we don't have playercards right now
    @Test
    public void getHasPlayerCard() {
        Player p1 = new Player();
        p1.setHasPlayerCard(true);
        assertTrue(p1.getHasPlayerCard());
    }
}
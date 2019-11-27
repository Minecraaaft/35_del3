package test;

import DTU35_del3.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceTest {

    @Test
    public void addToBalance() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.addToBalance(2);
        p2.addToBalance(3);
        p3.addToBalance(-23);

        assertEquals(22,p1.getBalance());
        assertEquals(23,p2.getBalance());
        assertEquals(-3,p3.getBalance());
    }

    @Test
    public void removeFromBalance() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        p1.removeFromBalance(23);
        p2.removeFromBalance(3);
        p3.removeFromBalance(-5);

        assertEquals(-3,p1.getBalance());
        assertEquals(17,p2.getBalance());
        assertEquals(25,p3.getBalance());
    }

    @Test
    public void getBalance() {
        Player p1 = new Player();
        Player p2 = new Player();
        p1.setBalance(84213);
        p2.setBalance(-312);
        assertEquals(84213,p1.getBalance());
        assertEquals(-312,p2.getBalance());
    }
}
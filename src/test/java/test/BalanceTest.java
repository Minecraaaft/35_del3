package test;

import DTU35_del3.player.Balance;
import DTU35_del3.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceTest {

    @Test
    public void getOwner() {
        Balance p1 = new Balance("abcd", 20);
        assertEquals("abcd", p1.getOwner());
    }

    @Test
    public void getBalance() {
        Balance p1 = new Balance("abcd", 20);
        assertEquals(20, p1.getBalance());
        p1.setBalance(10);
        assertEquals(10, p1.getBalance());
    }

    @Test
    public void addToBalance() {
        Balance p1 = new Balance("abcd", 20);
        p1.addToBalance(10);
        assertEquals(30, p1.getBalance());
    }

    @Test
    public void removeFromBalance() {
        Balance p1 = new Balance("abcd", 20);
        p1.removeFromBalance(10);
        assertEquals(10, p1.getBalance());
    }
}
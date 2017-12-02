package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class testDeck {

    @Test
    public void testNewDeck() {
        Deck d = new Deck();
        assertNotNull(d);
    }
    @Test
    public void testDeckBuilt() {
        Deck d = new Deck();
        assertEquals(52, d.cards.size());
    }
    @Test
    public void testShuffle() {
        Deck d1 = new Deck();
        d1.shuffle();
        Deck d2 = new Deck();
        d2.shuffle();
        assertFalse(Arrays.equals(d1.cards.toArray(), d2.cards.toArray()));
    }

}

package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class testGeneralDeck {
    @Test
    public void testNewGenDeck() {
        GeneralDeck gd = new GeneralDeck();
        assertNotNull(gd);
    }
    @Test
    public void testGenDeckShuffle() {
        GeneralDeck gd1 = new SpanishDeck();
        gd1.shuffle();
        GeneralDeck gd2 = new SpanishDeck();
        gd2.shuffle();
        assertFalse(Arrays.equals(gd1.cards.toArray(), gd2.cards.toArray()));
    }
    @Test
    public void testGenDeckDealFour() {
        GeneralDeck gd = new SpanishDeck();
        gd.shuffle();
        assertEquals(4, gd.dealFour().size());
    }
}

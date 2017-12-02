package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class testSpanishDeck {

    @Test
    public void testNewDeck() {
        SpanishDeck d = new SpanishDeck();
        assertNotNull(d);
    }
    @Test
    public void testDeckBuilt() {
        SpanishDeck d = new SpanishDeck();
        assertEquals(50, d.cards.size());
    }
    @Test
    public void testShuffle() {
        SpanishDeck d1 = new SpanishDeck();
        d1.shuffle();
        SpanishDeck d2 = new SpanishDeck();
        d2.shuffle();
        assertFalse(Arrays.equals(d1.cards.toArray(), d2.cards.toArray()));
    }

}

package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testCard {

    @Test
    public void testCard() {
        Card c = new Card(12, Suit.Clubs);
    }
    @Test
    public void testGetValue() {
        Card c = new Card(12, Suit.Clubs);
        assertEquals(12, c.getValue());
    }
    @Test
    public void testGetSuit() {
        Card c = new Card(12, Suit.Clubs);
        assertEquals(Suit.Clubs, c.getSuit());
    }
    @Test
    public void testToString() {
        Card c = new Card(12, Suit.Clubs);
        assertEquals("12Clubs", c.toString());
    }

}

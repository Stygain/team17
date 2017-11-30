package models;

import org.junit.Test;

public class testDeck {

    @Test
    public void testShuffle() {
        Deck d = new Deck();
        d.shuffle();
    }
    @Test
    public void testDealFour() {
        Deck d = new Deck();
        d.dealFour();
    }

}

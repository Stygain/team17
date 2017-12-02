package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testGame {
    @Test
    public void testNewGame() {
        Game g = new Game();
        assertNotNull(g);
    }
    @Test
    public void testBuildDeck() {
        Game g = new Game();
        g.deck = new Deck();
        assertEquals(52, g.deck.cards.size());
    }
    @Test
    public void testGameShuffle() {
        Game g1 = new Game();
        g1.deck.shuffle();
        Game g2 = new Game();
        g2.deck.shuffle();
        assertFalse(Arrays.equals(g1.deck.cards.toArray(), g2.deck.cards.toArray()));
    }
    @Test
    public void testDealFour() {
        Game g = new Game();
        g.deck.shuffle();
        g.dealFour();
        assertEquals(1,g.columns.get(0).cards.size());
        assertEquals(1,g.columns.get(1).cards.size());
        assertEquals(1,g.columns.get(2).cards.size());
        assertEquals(1,g.columns.get(3).cards.size());
    }
    @Test
    public void testCustomDeal() {//Bhavya did this one
        Game g = new Game();
        g.deck = new Deck();
        g.customDeal(0, 3, 6, 9);
        assertEquals("2Clubs",g.columns.get(0).cards.get(0).toString());
        assertEquals("3Clubs",g.columns.get(1).cards.get(0).toString());
        assertEquals("4Clubs",g.columns.get(2).cards.get(0).toString());
        assertEquals("5Clubs",g.columns.get(3).cards.get(0).toString());
    }
    @Test
    public void testRemove() {//Jason did this one
        Game g = new Game();
        g.customDeal(0, 3, 6, 9);
        g.remove(2);
        assertEquals(0, g.columns.get(2).cards.size());
    }
    @Test
    public void testColumnHasCards() {//Ayush did this one
        Game g = new Game();
        assertFalse(g.columnHasCards(0));
        g.dealFour();
        assertTrue(g.columnHasCards(0));
    }
    @Test
    public void testGetTopCard() {
        Game g = new Game();
        g.deck = new Deck();
        g.customDeal(0, 3, 6, 9);
        assertEquals("2Clubs", g.getTopCard(0).toString());
    }
    @Test
    public void testMove() {
        Game g = new Game();
        g.deck = new Deck();
//        g.newGame(0);
        g.customDeal(0, 3, 6, 45);
        g.remove(0);
        g.move(3, 0);
        assertEquals("14Clubs", g.columns.get(0).cards.get(0).toString());
    }
    @Test
    public void testNewGameDeck() {
        Game g = new Game();
        g.newGame(0);
        assertNotNull(g.deck);
    }
    @Test
    public void testNewGameSpanish() {
        Game g = new Game();
        g.newGame(1);
        assertNotNull(g.deck);
    }
}

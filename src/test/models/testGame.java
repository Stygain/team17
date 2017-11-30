package models;

import org.junit.Test;

public class testGame {
    @Test
    public void testDealFour() {
        Game g = new Game();
        g.dealFour();
    }
    @Test
    public void testCustomDeal() {//Bhavya did this one
        Game g = new Game();
        g.customDeal(0, 0, 0, 0);
    }
    @Test
    public void testRemove() {//Jason did this one
        Game g = new Game();
        g.dealFour();
        g.remove(0);
    }
    @Test
    public void testColumnHasCards() {//Ayush did this one
        Game g = new Game();
        g.columnHasCards(0);
        for (int i = 0; i < 4; i++) {
            g.remove(i);
            g.columnHasCards(i);
        }
    }
    @Test
    public void testGetTopCard() {
        Game g = new Game();
        g.dealFour();
        g.getTopCard(0);
    }
    @Test
    public void testMove() {
        Game g = new Game();
        g.dealFour();
        g.move(0, 1);
    }
}

package models;

import org.junit.Test;

public class testGame {
    @Test
    public void testDealFour() {
        Game g = new Game();
        g.dealFour();
    }
    @Test
    public void testCustomDeal() {
        Game g = new Game();
        g.customDeal(0, 1, 2, 3);
    }
    @Test
    public void testRemove() {
        Game g = new Game();
        g.dealFour();
        g.remove(0);
    }
}

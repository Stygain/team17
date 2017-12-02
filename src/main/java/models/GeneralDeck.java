package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GeneralDeck {

    public java.util.List<Card> cards = new ArrayList<>();

    public GeneralDeck() {

    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    public ArrayList<Card> dealFour() {
        ArrayList<Card> four = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (cards.size() > 0) {
                four.add(cards.get(i));
                cards.remove(i);
            }
        }
        return four;
    }
}



package models;

public class SpanishDeck extends GeneralDeck {

    public SpanishDeck() {

        for (int i = 1; i < 13; i++) {

            cards.add(new Card(i,Suit.Clubs));
            cards.add(new Card(i,Suit.Cups));
            cards.add(new Card(i,Suit.Coins));
            cards.add(new Card(i,Suit.Swords));

        }

        cards.add(new Card(0,Suit.Jokers));
        cards.add(new Card(0,Suit.Jokers));

    }
}

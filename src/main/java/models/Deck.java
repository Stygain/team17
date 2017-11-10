package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.io.Serializable;

public class Deck implements Serializable {

    private int size;
    private java.util.List<Card> deck = new ArrayList<>();


    @JsonCreator
    public Deck(){
        buildDeck();
        shuffle();

    }

    public int getSize() {return size;}
    public void setSize(int newSize) {size = newSize;}
    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }
    public void shuffle() {
        int randomVal;
        Card currCard;

        Card newCard;
        for (int i = 0; i < deck.size(); i++){
            randomVal = (int) (Math.random() * 52);
            currCard = deck.get(randomVal);
            newCard = new Card(currCard.getValue(), currCard.getSuit());
            deck.remove(randomVal);
            deck.add(newCard);
        }
        // shuffles the deck so that it is random
    }
    public Card getTopCard() {

        Card temp = deck.get(deck.size()-1);
        removeTop();
        return temp;

    }
    public void removeTop() {

        deck.remove(deck.size()-1);
        this.size = this.size-1;

    }


}

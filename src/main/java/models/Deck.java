package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.io.Serializable;

public class Deck implements Serializable {

    private int size;
    private java.util.List<Card> deck = new ArrayList<>(52);


    @JsonCreator
    public Deck(){
        //buildDeck();
        shuffle();

    }

    public int getSize() {
        return size;
    }

    public void setSize(int newSize) {
        size = newSize;
    }

    public void buildDeck() {
        System.out.println("Im building the deck");
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
        System.out.println("attempting to get a card value " + peekTop().suit + " " + peekTop().value);
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
        //System.out.println("Getting shuffled top " + peekTop().suit + " " + peekTop().value);
    }

    public Card getTopCard() {

        Card temp = deck.get(deck.size()-1);
        removeTop();
        return temp;

    }

    public Card peekTop() {

        return deck.get(deck.size()-1);

    }

    public void removeTop() {

        deck.remove(deck.size()-1);
        this.size = this.size-1;

    }


}

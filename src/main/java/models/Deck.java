package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.io.Serializable;

public class Deck implements Serializable {

    private java.util.List<Card> deck = new ArrayList<>(52);

    public Deck(){
        buildDeck();
        shuffle();
    }
    public int getSize() {
        return deck.size();
    }

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

/*    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        int cards = deck.size();
        System.out.println("The four cards dealt were:");
        if (cards >= 4){
            for(int i = 0; i < 4; i++) {
                //OO update
                //Card temp = deck.getTopCard();

                //original
//                Card temp = this.deck.get(this.deck.size()-1);// remove top card from deck
//                this.addCardToCol(i, temp);//add card to column
//                this.deck.remove(temp);//remove top card from deck

                Card temp = this.getTopCard();
                System.out.println("Card: " + temp.value + " " + temp.suit);
                Game.addCardToCol(i, temp);

                //OO update
                // cols2.get(0).get(i).addCard(temp);
            }
        }
        else{
            System.out.println("Out of Cards");
        }
    }*/

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

    }
}

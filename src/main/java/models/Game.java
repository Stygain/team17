package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        this.buildDeck();
        this.shuffle();
        //this.dealFour();
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
            randomVal = (int) Math.random() * 52;
            currCard = deck.get(randomVal);
            newCard = new Card(currCard.getValue(), currCard.getSuit());
            deck.remove(randomVal);
            deck.add(newCard);
        }
        // shuffles the deck so that it is random

    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        int cards = this.deck.size();
        if (cards >= 4){
            for(int i = 0; i < 4; i++) {
                //Card temp = this.cols.get(i).get(this.cols.get(i).size()-1);
                Card temp = this.deck.get(this.deck.size()-1);// remove top card from deck
                this.deck.remove(temp);
                this.cols.get(i).add(temp);// adds card to a column
            }
        }
        else{
            System.out.println("Out of Cards");
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        if(columnHasCards(columnNumber)) {

            removeCardFromCol(columnNumber);

        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if (this.cols.get(columnNumber).isEmpty()) {
            return false;
        }
        return true;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (columnHasCards(columnFrom)) {
            Card temp = getTopCard(columnFrom);
            this.cols.get(columnFrom).remove(temp);
            this.cols.get(columnTo).add(temp);
        }
        //cols.get(columnFrom).get(cols.get(columnFrom).size()-1);
        //cols.get(columnTo).get(cols.get(columnTo).size()+1);
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}

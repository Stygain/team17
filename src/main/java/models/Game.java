package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public Deck deck = new Deck();

    //public java.util.List<Card> deck = new ArrayList<>();

    //public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);
    public java.util.List<Column> cols;// = new ArrayList<>(4);

    public Game(){
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++){
            cols.add(new Column());
        }
        //this.dealFour();
    }

//    public void buildDeck() {
//        for(int i = 2; i < 15; i++){
//            deck.add(new Card(i,Suit.Clubs));
//            deck.add(new Card(i,Suit.Hearts));
//            deck.add(new Card(i,Suit.Diamonds));
//            deck.add(new Card(i,Suit.Spades));
//        }
//    }

//    public void shuffle() {
//        int randomVal;
//        Card currCard;
//
//        Card newCard;
//        for (int i = 0; i < deck.size(); i++){
//            randomVal = (int) (Math.random() * 52);
//            currCard = deck.get(randomVal);
//            newCard = new Card(currCard.getValue(), currCard.getSuit());
//            deck.remove(randomVal);
//            deck.add(newCard);
//        }
//        // shuffles the deck so that it is random
//    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        int cards = deck.getSize();
        if (cards >= 4){
            for(int i = 0; i < 4; i++) {
                Card temp = deck.getTopCard();
                //Card temp = this.deck.get(this.deck.size()-1);// remove top card from deck
                cols.get(i).addCard(temp);
                //this.addCardToCol(i, temp);//add card to column
                //this.deck.remove(temp);//remove top card from deck
            }
        }
        else{
            System.out.println("Out of Cards");
        }
    }

    public boolean remove(int columnNumber) {
        // remove the top card from the indicated column
        if(cols.get(columnNumber).hasCards()/*columnHasCards(columnNumber)*/) {
            for (int i = 0; i < 4; i++){
                if(cols.get(i).peekTop().suit == cols.get(columnNumber).peekTop().suit
                        && cols.get(i).peekTop().value > cols.get(columnNumber).peekTop().value) {
                        cols.get(columnNumber).removeCard();
                        return true;
                }
                /*if (this.cols.get(i).get(this.cols.get(i).size()-1).suit == this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1).suit &&
                        this.cols.get(i).get(this.cols.get(i).size()-1).value > this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1).value) {
                    removeCardFromCol(columnNumber);
                }*/
            }
        }
        return false;
    }
/*
    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
       /* if(cols.get(columnNumber).hasCards()) {
            return true;
        }
        return false;
//        if (this.cols.get(columnNumber).isEmpty()) {
//            return false;
//        }
//        return true;
    }
*/
/*
    private Card getTopCard(int columnNumber) {
        //return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);

    }*/


    public boolean move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (cols.get(columnFrom).hasCards()/*columnHasCards(columnFrom)*/) {
            if (cols.get(columnTo).hasCards()/*columnHasCards(columnTo)*/ == false) {
                Card temp = cols.get(columnFrom).getTop();
                        //getTopCard(columnFrom); //get the top card
                cols.get(columnTo).addCard(temp);
                return true;
                //addCardToCol(columnTo, temp); //add it to the new column
                //removeCardFromCol(columnFrom); //remove from the from column
            }
        }
        return false;
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        //this.cols.get(columnTo).add(cardToMove);
        cols.get(columnTo).addCard(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        //this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
        cols.get(colFrom).removeCard();
    }
}

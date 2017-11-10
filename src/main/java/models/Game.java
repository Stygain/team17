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

    //old
    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    //OO update
    //public java.util.List<Column> cols;// = new ArrayList<>(4);
    //public java.util.List<java.util.List<Column>> cols2 = new ArrayList<>(1);

    public Game(){
        // initialize a new game such that each column can store cards
        /*cols2.add(new ArrayList<Column>(4));
        for (int i = 0; i < 4; i++) {
            cols2.get(0).add(new Column());
        }*/
        //original
        for (int i = 0; i < 4; i++){
            cols.add(new ArrayList<Card>(4));
        }
        /*OO update
        for (int i = 0; i < 4; i++){
            cols.add(new Column());
        }*/
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
                //OO update
                //Card temp = deck.getTopCard();

                //original
//                Card temp = this.deck.get(this.deck.size()-1);// remove top card from deck
//                this.addCardToCol(i, temp);//add card to column
//                this.deck.remove(temp);//remove top card from deck

                Card temp = deck.getTopCard();
                this.addCardToCol(i, temp);

                //OO update
                // cols2.get(0).get(i).addCard(temp);
            }
        }
        else{
            System.out.println("Out of Cards");
        }
    }

    public boolean remove(int columnNumber) {
        // remove the top card from the indicated column
        if(columnHasCards(columnNumber)) {
            for (int i = 0; i < 4; i++){
                /*if(cols2.get(0).get(i).peekTop().suit == cols2.get(0).get(columnNumber).peekTop().suit
                        && cols2.get(0).get(i).peekTop().value > cols2.get(0).get(columnNumber).peekTop().value) {
                    cols2.get(0).get(columnNumber).removeCard();
                        return true;
                }*/
                if (this.cols.get(i).get(this.cols.get(i).size()-1).suit == this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1).suit &&
                        this.cols.get(i).get(this.cols.get(i).size()-1).value > this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1).value) {
                    removeCardFromCol(columnNumber);
                }
            }
        }
        return false;
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        //OO update
        /*if(cols.get(columnNumber).hasCards()) {
            return true;
        }
        return false;*/
        if (this.cols.get(columnNumber).isEmpty()) {
            return false;
        }
        return true;
    }


    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public boolean move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if (/*cols2.get(0).get(columnFrom).hasCards()*/columnHasCards(columnFrom)) {
            for (int i = 0; i < 4; i++) {
                if (/*cols2.get(0).get(columnTo).hasCards()*/columnHasCards(i) == false) {
                    /*Card temp = cols2.get(0).get(columnFrom).getTop();
                            //getTopCard(columnFrom); //get the top card
                    cols2.get(0).get(columnTo).addCard(temp);
                    return true;*/

                    Card temp = getTopCard(columnFrom);
                    addCardToCol(columnTo, temp); //add it to the new column
                    removeCardFromCol(columnFrom); //remove from the from column
                    return true;
                }
            }
        }
        return false;
    }

    public void addCardToCol(int columnTo, Card cardToMove) {
        this.cols.get(columnTo).add(cardToMove);
        //cols2.get(0).get(columnTo).addCard(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
        //cols2.get(0).get(colFrom).removeCard();
    }
}

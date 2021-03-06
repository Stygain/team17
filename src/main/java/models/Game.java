package models;

import java.util.ArrayList;

public class Game {

    public GeneralDeck deck = new SpanishDeck();
    public java.util.List<Column> columns = new ArrayList<>();

    public Game(){
        columns.add(new Column(1));
        columns.add(new Column(2));
        columns.add(new Column(3));
        columns.add(new Column(4));
    }

    public void dealFour() {
        ArrayList<Card> deal = deck.dealFour();
        for (int i = 0; i < deal.size(); i++) {
            Card c = deal.get(i);
            columns.get(i).cards.add(c);
        }
    }

    //customDeal to setup game for testing purposes (i.e. shuffled cards are random and hard to test)
    public void customDeal(int c1, int c2, int c3, int c4) {
        columns.get(0).cards.add(deck.cards.get(c1));
        deck.cards.remove(c1);
        columns.get(1).cards.add(deck.cards.get(c2));
        deck.cards.remove(c2);
        columns.get(2).cards.add(deck.cards.get(c3));
        deck.cards.remove(c3);
        columns.get(3).cards.add(deck.cards.get(c4));
        deck.cards.remove(c4);
    }

    public void remove(int columnNumber) {
        if(columnHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            int jokerCard = -1;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        } else if(compare.getValue() == 0) {
                            jokerCard = i;
                        }
                    }
                }
            }
            if (removeCard) {
                this.columns.get(columnNumber).cards.remove(this.columns.get(columnNumber).cards.size() - 1);
            } else if(jokerCard != -1){

                removeCardFromCol(columnNumber);
                removeCardFromCol(jokerCard);

            }
        }
    }

    boolean columnHasCards(int columnNumber) {
        if (this.columns.get(columnNumber).cards.size()>0) {
            return true;
        }
        return false;
    }

    Card getTopCard(int columnNumber) {
        return this.columns.get(columnNumber).cards.get(this.columns.get(columnNumber).cards.size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        Card cardToMove = getTopCard(columnFrom);
        if (cardToMove.getValue() == 14 && !columnHasCards(columnTo)) {
            this.removeCardFromCol(columnFrom);
            this.addCardToCol(columnTo, cardToMove);
        }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        columns.get(columnTo).cards.add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.columns.get(colFrom).cards.remove(this.columns.get(colFrom).cards.size()-1);
    }

    public void newGame(int deckType) {

        GeneralDeck newDeck;

        if(deckType == 0) { //standard deck

            newDeck = new Deck();

        }
        else { //spanish deck

            newDeck = new SpanishDeck();

        }

        for (int i = 0; i < 4; i++) {
            while (columnHasCards(i)) {
                removeCardFromCol(i);
            }
        }

        this.deck = newDeck;
        this.deck.shuffle();
        this.dealFour();

    }

}
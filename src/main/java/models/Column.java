package models;

//import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.io.Serializable;



public class Column {

    private int size;
    private java.util.List<Card> column;

    public Column(){
        column = new ArrayList<>();
    }

    public void addCard(Card newCard) {

        column.add(newCard);

    }
    public Card getTop(){
        Card returnCard = column.get(column.size()-1);
        removeCard();
        return returnCard;
    }
    public void removeCard(){

        column.remove(column.size()-1);

    }
    public Card peekTop() {
        Card returnCard = column.get(column.size()-1);
        return returnCard;
    }



    public boolean hasCards() {

        if (column.size() == 0) {

            return false;

        }
        return true;

    }

}

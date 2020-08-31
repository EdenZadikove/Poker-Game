package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }
    public  void getCards(){
        //generate cards
        for(CardColor cardColor: CardColor.values()){
            for(CardValue cardValue: CardValue.values() ) {
                //add a new card to the mix
                this.cards.add(new Card(cardColor, cardValue));
            }
        }

    }

    public void shuffle() {
        ArrayList<Card> tmpDeck = new ArrayList<Card>();

        //Use random
        Random random = new Random();
        int randomCardIndex = 0;
        int handSize = 5;
        for (int i = 0; i < 5; i++) {
            //Generate random index
            randomCardIndex = random.nextInt(5) + 1;
            tmpDeck.add(this.cards.get(randomCardIndex));

            //remove from original deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }

    public String toString() {
        String cardListOutput ="";
        int i = 0;
        for(Card card : this.cards) {
            cardListOutput +="\n" + i + "-" +  card.toString();
            i++;
        }
        return cardListOutput;
    }
}

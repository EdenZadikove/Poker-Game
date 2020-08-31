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
        int originalSize  = this.cards.size();
        for (int i = 0; i < 5; i++) {
            //Generate random index
            randomCardIndex = random.nextInt((this.cards.size()-1-0) + 1) + 0;
            tmpDeck.add(this.cards.get(randomCardIndex));

            //remove from original deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }

    public String toString() {
        String cardListOutput ="";
        int i = 1;
        for(Card card : this.cards) {
            cardListOutput +="\n" + i + "-" +  card.toString();
            i++;
        }
        return cardListOutput;
    }

    public int checkPair() {
        int i, j, cardCounter = 0, pairCounter = 0 ;

        for(i = 0; i < cards.size(); i++) {
            Card tmpCard = cards.get(i);
            cardCounter = 1;
            for(j = i+1; j < cards.size(); j++) {
                if(tmpCard == cards.get(j)) cardCounter++; //congratulation you got a pair
            }
            if(cardCounter == 2)
                pairCounter++;
        }
        return pairCounter;
    }

    public int checkTreeOrFour() {
        int i, j, cardCounter = 0;

        for(i = 0; i < cards.size(); i++) {
            Card tmpCard = cards.get(i);
            cardCounter = 1;
            for(j = i+1; j < cards.size(); j++) {
                if(tmpCard == cards.get(j)) cardCounter++; //congratulation you got a pair
            }
            if(cardCounter == 3 || cardCounter == 4)
               return cardCounter;
        }
        return 0; //no three of a kind or four of a kind
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards; //cards package
    private Player player;

    public Deck(){
        this.cards = new ArrayList<Card>();
        this.player = new Player();
    }

    public Player getPlayer() {
        return player;
    }

    public  void createCardsPackage(){
        //generate cards
        for(CardColor cardColor: CardColor.values()){
            for(CardValue cardValue: CardValue.values() ) {
                //add a 2 same new cards to the mix
                this.cards.add(new Card(cardColor, cardValue));
                this.cards.add(new Card(cardColor, cardValue));
            }
        }
    }

    public void shuffle() { //shuffle the cards package
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        //Use random
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize  = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            //Generate random index
            randomCardIndex = random.nextInt((this.cards.size()-1-0) + 1) + 0;
            tmpDeck.add(this.cards.get(randomCardIndex));

            //remove from original deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }

    public void createHand(){
        //get 5 random cards and insert them into player's hand
        int i, randomCardIndex = 0;
        ArrayList<Card> tmpHand = new ArrayList<Card>();
        for(i = 0; i < 5; i++) {
            tmpHand.add(cards.get(i));
        }
        player.setHand(tmpHand);

    }


    public int checkPair() {
        int i, j, cardsCounter = 0, pairCounter = 0 ;
        ArrayList<Card> playerHand = player.getHand();
        //sort hand
        for(i = 0; i < playerHand.size(); i++) {
            Card tmpCard = playerHand.get(i);
            cardsCounter = 1;
            for(j = i+1; j < playerHand.size(); j++) {
                if (tmpCard == playerHand.get(j)) cardsCounter++; //congratulation you got a pair
                else break;
            }
            if(cardsCounter == 2)
                pairCounter++;
            i = j-1; //next different card
        }
        return pairCounter;
    }

    public int checkTreeOrFour() {
        int i, j, cardCounter = 0;
        ArrayList<Card> playerHand = player.getHand();
        for(i = 0; i < playerHand.size(); i++) {
            Card tmpCard = playerHand.get(i);
            cardCounter = 1;
            for(j = i+1; j < playerHand.size(); j++) {
                if(tmpCard == playerHand.get(j)) cardCounter++; //congratulation you got a pair
            }
            if(cardCounter == 3 || cardCounter == 4)
               return cardCounter;
        }
        return 0; //no three of a kind or four of a kind
    }

    public void resetGame() {
        //reset the game in order to start over
        cards.clear();
        player.setHand(cards); //empty array list
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

    //Test method
    public void createHandTEST(){
        //get 5 random cards and insert them into player's hand
        int i, randomCardIndex = 0;
        ArrayList<Card> tmpHand = new ArrayList<Card>();

        tmpHand.add(cards.get(1));
        tmpHand.add(cards.get(2));
        tmpHand.add(cards.get(1));
        tmpHand.add(cards.get(2));
        tmpHand.add(cards.get(2));

        player.setHand(tmpHand);
    }

}

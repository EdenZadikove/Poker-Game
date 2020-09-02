package com.company;

import java.util.ArrayList;
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
        int randomCardIndex = 0;
        int originalSize  = this.cards.size();
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();

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
        int i;
        ArrayList<Card> tmpHand = new ArrayList<Card>();
        for(i = 0; i < 5; i++)
            tmpHand.add(cards.get(i));
        player.setHand(tmpHand);
    }

    /*Search on sorted hand only!*/
    public String checkHand() {
        int i, j = 0, cardsCounter = 0, pairsCounter = 0, threeCounter = 0, fourCounter = 0;
        String result = "No hand";
        ArrayList<Card> playerHand = player.getHand();

        for(i = 0; i < playerHand.size(); i = j) {
            cardsCounter = 1;
            for(j = i+1; j < playerHand.size(); j++) {
                if (playerHand.get(i).equals(playerHand.get(j)))
                    cardsCounter++;
                else break;
            }
            switch (cardsCounter) {
                case 2:
                    pairsCounter++;
                    result = "1 pair";
                    if(pairsCounter == 1 && threeCounter == 1)
                        result = "Full House";
                    if(pairsCounter == 2) {
                        result = "2 pairs";
                        i = playerHand.size(); // no point to continue checking.
                    }
                    break;
                case 3:
                    threeCounter++;
                    result = "Three of a kind";
                    if(pairsCounter == 1)
                        result = "Full House";
                    break;
                case 4:
                    fourCounter++;
                    result = "Four of a kind";
                    i = playerHand.size(); // no point to continue checking.
                default:
                    break;
            }
        }
        return result;
    }

    public void resetGame() {
        //reset the game in order to start over
        cards.clear(); //clear the cards array list
        player.setHand(cards); //clear user's hand
    }

    public String toString() {
        String cardListOutput = "";
        int i = 1;
        for(Card card : this.cards)
            cardListOutput +=(i++) + "-" +  card.toString() +"\n";
        return cardListOutput;
    }

    /*Test method- change the index according to the case you want to check.
    e.g the indexes below for - Three of a kind.*/
    public void createHandTEST(){
        ArrayList<Card> tmpHand = new ArrayList<Card>();
        tmpHand.add(cards.get(0));
        tmpHand.add(cards.get(2));
        tmpHand.add(cards.get(1));
        tmpHand.add(cards.get(1));
        tmpHand.add(cards.get(1));

        player.setHand(tmpHand);
    }

}

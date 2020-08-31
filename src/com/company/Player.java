package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    public Player() { }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        String cardListOutput ="Player hand:\n";
        int i = 1;

        for(Card card : this.hand) {
            cardListOutput +="\n" + i + "-" +  card.toString();
            i++;
        }
        return cardListOutput;
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player {
    private ArrayList<Card> hand;

    public Player() { }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void sortHand() {
        Collections.sort(hand, Comparator.comparing(Card::getCardValue));
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

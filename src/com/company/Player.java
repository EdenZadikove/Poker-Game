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
        Collections.sort(hand, new Comparator() {
            public int compare(Object o1, Object o2) {

                CardValue x1 = ((Card) o1).getCardValue();
                CardValue x2 = ((Card) o2).getCardValue();
                int sComp = x1.compareTo(x2);

                if (sComp != 0)
                    return sComp;

                CardColor y1 = ((Card) o1).getCardColor();
                CardColor y2 = ((Card) o2).getCardColor();
                return y1.compareTo(y2);
        }});
    }

    @Override
    public String toString() {
        String cardListOutput = "";
        int i = 1;
        for(Card card : this.hand)
            cardListOutput += (i++) + "-" +  card.toString() + "\n";
        return cardListOutput;
    }
}

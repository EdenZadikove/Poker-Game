package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    public Player(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}

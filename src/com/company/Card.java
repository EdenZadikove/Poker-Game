package com.company;

public class Card {
    private CardColor cardColor;
    private CardValue cardValue;

    public Card(CardColor cardColor, CardValue cardValue){
        this.cardColor = cardColor;
        this.cardValue = cardValue;
    }
    public CardColor getCardColor() {
        return this.cardColor;
    }
    public CardValue getCardValue() {
        return this.cardValue;
    }

    @Override
    public String toString() {
        return this.cardValue.toString() + "-" +this.cardColor.toString();
    }
}

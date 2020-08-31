package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// welcome message
        System.out.println("Welcome to poker");

        //create our playing hand
        Deck playingDeck = new Deck();
        playingDeck.getCards();
        playingDeck.shuffle();

        System.out.println(playingDeck);

    }
}

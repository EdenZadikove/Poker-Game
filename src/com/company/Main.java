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


        //check for 1 pair of two pairs
        int pairCounter = playingDeck.checkPair();
        //check for three or four of a kind
        int threeOrFour = playingDeck.checkTreeOrFour();


        //print results
        System.out.println(playingDeck +"\n");

        //print pair/ pairs only if the player got one
        if(pairCounter != 0)
            System.out.println("You got " + pairCounter + " pairs.");

        switch (threeOrFour){
            case 3:
                System.out.println("You got three of a kind");
                break;
            case 4:
                System.out.println("You got four of a kind");
                break;
            default:
                if(pairCounter == 0 && threeOrFour == 0)
                   System.out.println("Sorry, you got no hand");
                else if(pairCounter == 1 && threeOrFour == 3) //one pair and one three of a kind
                    System.out.println("Congratulation, you got a Full House");
        }


    }
}

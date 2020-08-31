package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // welcome message
        System.out.println("Welcome to poker");

        //variables
        boolean gameLive = true;
        Deck playingDeck = new Deck();


        //create our playing hand
        playingDeck.createCardsPackage();
        playingDeck.shuffle();
        playingDeck.createHand();
        playingDeck.getPlayer().sortHand();

        //check for 1 pair of two pairs
        int pairCounter = playingDeck.checkPair();
        //check for three or four of a kind
        int threeOrFour = playingDeck.checkTreeOrFour();

        //print results
        System.out.println("Cards package:\n" + playingDeck +"\n");
        System.out.println(playingDeck.getPlayer()+"\n");

        //print pair/pairs only if the player got one
        switch(pairCounter){
            case 1:
                if(threeOrFour == 3)
                    System.out.println("Congratulation, you got a Full House");
                else
                    System.out.println("You got " + pairCounter + "pair");
                gameLive = false;
                break;
            case 2:
                System.out.println("You got " + pairCounter + "pairs");
                gameLive = false;
                break;
            default:
                gameLive = true;
        }

        if(!gameLive) {
            //end the program
            System.exit(0);
        }

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
        }


    }
}

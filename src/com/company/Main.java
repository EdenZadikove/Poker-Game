package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // welcome message
        System.out.println("Welcome to Poker Game!\n");

        //variables
        boolean gameLive = true;
        Deck playingDeck = new Deck();

        while(gameLive) {
            playingDeck.resetGame();

            System.out.println("Shuffle the deck of cards...");
            System.out.println("Handing out cards to a player...\n");

            //create user playing hand
            playingDeck.createCardsPackage();
            playingDeck.shuffle();
            //playingDeck.createHand();

            //test method- enable line below to test
            playingDeck.createHandTEST();
            playingDeck.getPlayer().sortHand();

            //check which hand the user got.
            String handCheckResult = playingDeck.checkHand();

            //print results
            System.out.println("Player Hand: \n" + playingDeck.getPlayer());
            System.out.println("Result: " + handCheckResult +"\n");

            //Ask the user if wants another game
            System.out.println("Game over. Would you like to take another hand?\n(1- for another game, 0- exit the game)");
            Scanner scanner = new Scanner(System.in);
            int answer =  scanInt(scanner); // check input
            switch (answer) {
                case 1:
                    gameLive = true;
                    System.out.println("preparing a new game...\n");
                    break;
                case 0:
                    gameLive = false;
                    System.out.println("Existing the game...");
                    break;
                default:
                    break;
            }
        }
    }

    static int scanInt(Scanner scanner) {
        int answer = -1;
        boolean legalInput = false;
        while(!legalInput) {
            try{
                answer =  scanner.nextInt();
                if(answer != 1 && answer !=0) {
                    System.out.println("Illegal input. please press 1 OR 0");
                    legalInput = false;
                } else
                    legalInput = true;
            } catch(InputMismatchException e){
                System.out.println("Illegal input. please press 1 OR 0");
                scanner.nextLine();
            }
            System.out.println();
        }
        return answer;
    }
}
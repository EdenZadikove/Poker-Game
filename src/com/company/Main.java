package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // welcome message
        System.out.println("Welcome to poker");

        //variables
        boolean gameLive = true;
        Deck playingDeck = new Deck();

        while(gameLive) {
            playingDeck.resetGame();
            //create our playing hand
            playingDeck.createCardsPackage();
            playingDeck.shuffle();

           // playingDeck.createHand();
            //test method
            playingDeck.createHandTEST();
            playingDeck.getPlayer().sortHand();


            //check for 1 pair of two pairs
            int pairCounter = playingDeck.checkPair();
            //check for three or four of a kind
            int threeOrFour = playingDeck.checkTreeOrFour();

            //print results
            System.out.println("Cards package:\n" + playingDeck +"\n");
            System.out.println(playingDeck.getPlayer()+"\n");

            //print pair/pairs only if the player got one
            boolean isWinner = false;
            switch(pairCounter){
                case 1:
                    if(threeOrFour == 3)
                        System.out.println("Congratulation, you got a Full House");
                    else
                        System.out.println("You got " + pairCounter + " pair");
                    isWinner = true;
                    break;
                case 2:
                    System.out.println("You got " + pairCounter + " pairs");
                    isWinner = true;
                    break;
                default:
                    break;
            }
            if(!isWinner) {
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


            //another game
            System.out.println("Game over. Would you like to take another hand?\n(1- for another game, 0- exit the game)\n");
            Scanner scanner = new Scanner(System.in);
            int answer =  scanInt(scanner);

            switch (answer) {
                case 1:
                    gameLive = true;
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
                legalInput = true;
            } catch(InputMismatchException e){
                System.out.println("Illegal input. please press 1 OR 0\n");
                scanner.nextLine();
            }
        }
        return answer;
    }
}

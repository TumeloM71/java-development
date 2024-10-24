package com.pluralsight;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Deck deck =new Deck();
        deck.shuffle();
        Player dealer = new Player("Dealer");
        ArrayList<Player> players = new ArrayList<>();
        players.add(dealer);
        //for card counting;
        int runningCount = 0;

        Scanner keyboard = new Scanner(System.in);
        int numberOfPlayers ;
        System.out.print("How many players are partaking in the game? : ");
        numberOfPlayers = Utilities.getIntValue(keyboard.nextLine().trim());
        for (int i = 1; i<=numberOfPlayers; i++){
            Player player = new Player("Player "+i);
            players.add(player);
        }

        if(players.size() == 1)
            System.out.println("No players entered");

        else {
            for (int i = 0; i < 2; i++) {
                for (Player player : players) {
                    Card card = deck.deal();
                    player.getHand().deal(card);
                    runningCount+=card.getCount();
//                   System.out.println(player);
//                   System.out.println("Card count: "+card.getCount());
//                   System.out.println("Total count: "+runningCount);
                }
            }

            //Picks a random player who can see the card count
            Random random = new Random();
            int countSeer = random.nextInt(players.size());
            players.get(countSeer).setCanSeeCount(true);

            for(Player player : players){
                //Player can hit to be dealt another card or stand to remain with their current hand
                boolean stand = false;
                String playerChoice = "";
                while (!stand){
                    //Dealer can't hit if they have over 17 points
                    if( player.getName().equalsIgnoreCase("Dealer") && player.getHand().getValue()>16){
                        System.out.println(player.toString());
                        break;
                    }

                    System.out.print(player.getName()+"'s turn: ");
                    System.out.println(player.getHand());
                    System.out.print("Press H to hit or S to stand: ");
                    playerChoice = keyboard.nextLine().trim();
                    //Shows the count to the lucky player
                    if(player.canSeeCount)
                        System.out.println("Total count: "+runningCount);

                    if( playerChoice.equalsIgnoreCase("H") && deck.getSize()>0) {
                        Card card = deck.deal();
                        player.getHand().deal(card);
                        runningCount+=card.getCount();
                        if(player.getHand().getValue() > 21){
                            System.out.println(player.getHand());
                            System.out.println("You've gone bust!");
                            System.out.println();
                            stand = true;
                        }
                    }

                    else if(playerChoice.equalsIgnoreCase("S")){
                        System.out.println(); //Make an empty line for spacing
                        stand = true;
                    }
                    //Else will run when the deck is empty or the player enters invalid input
                    else {
                        if (deck.getSize() == 0)
                            System.out.println("Sorry, The deck is out of cards");
                        else
                            System.out.println("Invalid input");
                    }
                }
            }

            Hand winningHand = new Hand();
            Player winner = null;
            ArrayList<Player> winningPlayers = new ArrayList<>();
            boolean push = false;//A push/standoff happens when players tie for the highest score
            for (Player player : players) {
                System.out.println(player);
                Hand playerHand = player.getHand();
                if (winningHand.getValue() == playerHand.getValue()) {
                    push = true;
                    winningPlayers.add(player);
                }

                if (winningHand.getValue() < playerHand.getValue()
                        && playerHand.getValue() <= 21) {
                    winningHand = playerHand;
                    winner = player;
                    winningPlayers.clear();
                    winningPlayers.add(player);
                    push = false;
                }
            }
            System.out.println(); //Empty line for spacing
            if (push) {
                System.out.println("Highest scores tied. Standoff!");
                System.out.println("Winning players: ");
                for( Player p : winningPlayers)
                    System.out.println(p);
            }
            else if(winner == null)
                System.out.println("No winner!");
            else
                System.out.println(winner + " wins!!!");
        }

    }

}

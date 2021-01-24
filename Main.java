package Blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Deck deck = new Deck();
        boolean gameover = false;
        ArrayList<Player> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int standamount = 0;
        deck.shuffle();

        System.out.println("How many players would you like?");
        int amtofplayers = input.nextInt();

        for (int i = 0; i < amtofplayers; i++) {
            System.out.println("What is the the name of player " + (i + 1) + "?");
            String playername = input.next();
            ArrayList<Card> playerhand = new ArrayList<>();
            players.add(new Player(playerhand, playername));
        }

        ArrayList<Card> dealerhand = new ArrayList<>();
        players.add(new Dealer(dealerhand, "Dealer"));

        for (Player player : players) {
            player.hit(deck, player.getHand());
            player.hit(deck, player.getHand());
            player.hasBlackjack();
            player.printValues();
        }

        while(!gameover){
            if(players.size() <= 1){
                break;
            }
            for (int i = 0; i < players.size(); i++){
                String playerchoice = players.get(i).hitOrStand();
                while(playerchoice.equalsIgnoreCase("hit")){
                    players.get(i).hit(deck, players.get(i).getHand());
                    if(players.get(i).checkBust()){
                        players.remove(i);
                        break;
                    }
                    players.get(i).hasBlackjack();
                    players.get(i).printValues();
                    playerchoice = players.get(i).hitOrStand();
                }
                if(playerchoice.equalsIgnoreCase("stand")){
                    standamount += 1;
                }
                if(standamount >= players.size()){
                    gameover = true;
                }
            }
        }
        if(players.size() == 0){
            System.out.println("No winners!");
        }else {
            for (Player player : players) {
                System.out.println("Winner is: " +player.name+"!");
            }
        }

    }
}

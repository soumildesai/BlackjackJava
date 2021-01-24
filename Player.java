package Blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    public ArrayList<Card> hand; //users hand
    public int handvalue = 0;
    public String name;
    public Card[] aHand;
    Player(ArrayList<Card> hand, String name){
        this.hand = hand;
        this.name = name;
    }
    public void addCard(Card card){
        hand.add(card);
    }
    public boolean hasBlackjack(){
        if (handvalue == 21){
            System.out.println(name + " has blackjack!");
            return true;
        }
        else{
            return false;
        }
    }
    Scanner input = new Scanner(System.in);
    public String hitOrStand(){
        System.out.println("Would " + name + " like to hit or stand?\n");
        String choice = input.nextLine();
        return choice;
    }
    public int calcHandValue(ArrayList<Card> hand){
        aHand = hand.toArray(aHand);
        int handvalue=0;
        for(int i=0; i<aHand.length; i++)
        {
            handvalue += aHand[i].getValue();
            if(aHand[i].getValue()==11)
            {
                System.out.println("You have drawn an ace. Would you like it to be worth 11 or 1?");
                int acevalue = input.nextInt();
                if(acevalue == 1){
                    aHand[i].value = 1;
                }
            }
        }
        return handvalue;
    }
    public boolean checkBust(){
        if (handvalue > 21){
            System.out.println(name + " has busted!");
            return true;
        }
        return false;
    }
    public void hit(Deck deck, List<Card> hand)
    {
        hand.add(deck.drawCard());
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        handvalue = 0;
        for(int i=0; i<aHand.length; i++)
        {
            handvalue += aHand[i].getValue();
            if(aHand[i].getValue()==11)
            {
                System.out.println(name +" has drawn an ace. Would you like it to be worth 11 or 1?");
                int acevalue = input.nextInt();
                if(acevalue == 1){
                    aHand[i].value = 1;
                    hand.get(i).value = 1;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void printValues(){
        System.out.println(name+"'s hand is: "+hand);
        System.out.println(name+"'s hand's value is "+handvalue);
    }
}

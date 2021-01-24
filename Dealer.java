package Blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player{
    Dealer(ArrayList<Card> hand, String name) {
        super(hand, name);
    }
    private Card[] aHand;
    @Override
    public void hit(Deck deck, List<Card> hand){
        hand.add(deck.drawCard());
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        handvalue = 0;
        for(int i=0; i<aHand.length; i++)
        {
            handvalue += aHand[i].getValue();
            if(aHand[i].getValue()==11)
            {
                if (handvalue >= 11){
                    aHand[i].value = 1;
                }
            }
        }
    }
    @Override
    public String hitOrStand(){
        if (handvalue <= 16){
            return "hit";
        }
        else {
            return "stand";
        }
    }
    @Override
    public int calcHandValue(ArrayList<Card> hand){
        aHand = hand.toArray(aHand);
        int handvalue=0;
        for(int i=0; i<aHand.length; i++)
        {
            handvalue += aHand[i].getValue();
            if(aHand[i].getValue()==11)
            {
                if (handvalue >= 11){
                    aHand[i].value = 1;
                }
            }
        }
        return handvalue;
    }
    public void printValues(){
        System.out.println(name+"'s hand is: "+hand);
        System.out.println(name+"'s hand's value is "+handvalue);
    }

}

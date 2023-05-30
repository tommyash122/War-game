package com.company;


import java.security.SecureRandom;
import java.util.ArrayList;
//this class represents the deck of cards that we got to handle.
//from here we define the deck of cards and some functions that will help as get info on the deck of each player.
public class DeckOfCards
{
    //random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUM_OF_CARDS = 52;
    private final ArrayList<Card> deck = new ArrayList<>();

    //constructor fills the deck with cards
    public DeckOfCards()
    {
        String[] faces = {"Ace" , "Deuce" , "Three" , "Four" , "Five" , "Six" , "Seven" ,
                "Eight" , "Nine" , "Ten" , "Jack" , "Queen" , "King"};
        String[] suits = {"Hears" , "Diamonds" , "Clubs" , "Spades"};

        //inserts the cards to the deck
        for(int count=0 ; count < NUM_OF_CARDS ; count++)
            this.deck.add(new Card(faces[count%13] , suits[count/13]));

    }

    public void shuffle()
    {
        //for each Card , pick another random Card (0-51) and swap them
        for(int first = 0 ; first<deck.toArray().length ; first++)
        {
            //select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUM_OF_CARDS);

            //swap the current card with randomly selected card
            Card temp = this.deck.get(first);
            this.deck.set(first , this.deck.get(second));
            this.deck.set(second , temp);
        }
    }
    //deals one card
    public Card dealCard()
    {
        //if the deck is empty
        if(this.deck.isEmpty())
            return null;
        else
            return this.deck.remove(0);
    }

    public void ClearDeckOfCars()
    {
        this.deck.clear();
    }

    public void addCardToDeck(Card card)
    {

        this.deck.add(card);
    }

    public boolean NotEmptyDeck()
    {
        return !this.deck.isEmpty();
    }

    public int getTotNumOfCards()
    {
        return NUM_OF_CARDS;
    }

    public int getNumOfCards()
    {
        return this.deck.size();
    }


}

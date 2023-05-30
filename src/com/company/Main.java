package com.company;

import javax.swing.*;
// this class represents the main method. this method launch the program and manage all its actions.
public class Main {

    public static void main(String[] args) {
	    StartGame();
    }

    public static void StartGame()
    {
        //initialize the two players card deck and a general one
        DeckOfCards first_deck = new DeckOfCards();
        DeckOfCards second_deck = new DeckOfCards();
        DeckOfCards General_deck = new DeckOfCards();

        //clear the deck of the players, so they have no cards yet
        first_deck.ClearDeckOfCars();
        second_deck.ClearDeckOfCars();

        General_deck.shuffle();
        Dividing_cards(first_deck , second_deck , General_deck );
        General_deck.ClearDeckOfCars();

        // will be use for updates on the game status
        String str;
        int Num_of_rounds = 0;
        final int MAX_NUM_OF_ROUNDS = 1000; //this will determine how many rounds we want to play at max

        while(first_deck.NotEmptyDeck() && second_deck.NotEmptyDeck() && Num_of_rounds++<MAX_NUM_OF_ROUNDS)
        {
            Card first_card = first_deck.dealCard();
            Card second_card = second_deck.dealCard();

            str = "first player's card is: " + first_card.Cards_attribute() +
                    "\nsecond player's card is: "+ second_card.Cards_attribute();
            if(first_card.Card_Rank() > second_card.Card_Rank())
            {
                Cards_collector(first_deck,first_card,second_card,General_deck);
                str += "\n\nAnd the first player wins this round.";
                JOptionPane.showMessageDialog(null, str);
            }
            else if(first_card.Card_Rank() < second_card.Card_Rank())
            {
                Cards_collector(second_deck,first_card,second_card,General_deck);
                str += "\n\nAnd the second player wins this round.";
                JOptionPane.showMessageDialog(null, str);
            }
            else//if it's a tie
            {
                str +="\n\nLadies and Gentlemen, It's A WAR!";
                JOptionPane.showMessageDialog(null, str);

                for(int i = 0 ; i < 2 ; i++)
                {
                    /*we put two cards from each player in the pot,
                     the next round will be from the start of the while loop like a regular round*/
                    General_deck.addCardToDeck(first_deck.dealCard());
                    General_deck.addCardToDeck(second_deck.dealCard());
                }

            }

        }
        //this function will print the final state of the game (who is the winner ,if we got one).
        end_game(first_deck,second_deck);

    }

    public static void end_game( DeckOfCards first_deck ,  DeckOfCards second_deck)
    {
        String str = null;
        if(first_deck.getNumOfCards() > second_deck.getNumOfCards())
        {
            if(second_deck.NotEmptyDeck())
                str = "We pass the maximum number of rounds limit, our first player have more cards. it means that,";
            str += "\nFirst player wins the game, Congratulations!";
        }
        else if(first_deck.getNumOfCards() < second_deck.getNumOfCards())
        {
            if(first_deck.NotEmptyDeck())
                str = "We pass the maximum number of rounds limit, our second player have more cards. it means that,";
            str += "\nSecond player wins the game, Congratulations!";
        }
        // tie situation
        else
        {
            str = "It's a tie!";
        }

        JOptionPane.showMessageDialog(null, str);

    }

    public static void Cards_collector(DeckOfCards round_win_deck,Card first_card,Card second_card,DeckOfCards General_deck)
    {
        //we collect all the cards to put in the pot
        General_deck.addCardToDeck(first_card);
        General_deck.addCardToDeck(second_card);

        while(General_deck.NotEmptyDeck())
        {
            round_win_deck.addCardToDeck(General_deck.dealCard());
        }
        General_deck.ClearDeckOfCars();


    }



    public static void Dividing_cards(DeckOfCards first_deck ,DeckOfCards second_deck,DeckOfCards General_deck  )
    {
        for(int i = 0 ; i < General_deck.getTotNumOfCards() ; i++)
        {
            if(i%2 == 0)
                first_deck.addCardToDeck(General_deck.dealCard());
            else
                second_deck.addCardToDeck(General_deck.dealCard());
        }
    }



}

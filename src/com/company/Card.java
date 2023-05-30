package com.company;
//this class represents a card object and all its attributes.
//from here we define what is card.
public class Card
{
    private final String face;
    private final String suit;

    //constructor to initialize card's face and suit
    public Card(String cardFace , String cardSuit)
    {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    //return string representation of the card
    public String Cards_attribute()
    {
        return face + " of " + suit + ".";
    }

    public int Card_Rank()
    {
        String[] faces = {"Ace" , "Deuce" , "Three" , "Four" , "Five" , "Six" , "Seven" ,
                "Eight" , "Nine" , "Ten" , "Jack" , "Queen" , "King"};

        for(int i = 0 ; i< faces.length ; i++)
        {
            if(this.face.equals(faces[i]))
                return i + 1;
        }

        //the function will never end up here
        return -1;
    }
}

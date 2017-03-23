/*
 * Project 3 for CS 1181.
 * This program defines the DrawPile class and all of its data fields and methods using the 
 * NetBeans IDE. 
 * This program will represent and keep track of a deck of cards and store the methods necessary
 * to shuffle, deal, and reshuffle the deck.
 */
package project3_meyer;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Elijah Meyer
 * CS1181L-C07
 * Dr. Cheatham
 * Project 3
 */
public class DrawPile 
{
    private Queue<Card> deck = new LinkedList();
    
    public DrawPile()
    {
        
        // Load 52 Cards into the deck in sequential order
        for (int i = 0; i < 52; i++)
        {
            // Initialize variable
            String name = "";
            
            // Assign each Card an appropriate value
            int value = (i % 13) + 1;
            
            // Change Card's name to reflect its value
            switch(value)
            {
                case 1:
                {
                    name += "Ace of ";
                } break;
                
                case 2: 
                {
                    name += "Two of ";
                } break;
                
                case 3: 
                {
                    name += "Three of ";
                } break;
                
                case 4: 
                {
                    name += "Four of ";
                } break;
                
                case 5: 
                {
                    name += "Five of ";
                } break;
                
                case 6: 
                {
                    name += "Six of ";
                } break;
                
                case 7: 
                {
                    name += "Seven of ";
                } break;
                
                case 8: 
                {
                    name += "Eight of ";
                } break;
                
                case 9: 
                {
                    name += "Nine of ";
                } break;
                
                case 10: 
                {
                    name += "Ten of ";
                } break;
                
                case 11: 
                {
                    name += "Jack of ";
                } break;
                
                case 12: 
                {
                    name += "Queen of ";
                } break;
                
                case 13: 
                {
                    name += "King of ";
                } break;
            }
            
            // Assign suit to each Card 
            if (i < 13) 
            {
                name += "Spades";
            }
            else if (i < 26) 
            {
                name += "Hearts";
            }
            else if (i < 39) 
            {
                name += "Clubs";
            }
            else
            {
                name += "Diamonds";
            }
            
            // Add each Card to deck
            deck.offer(new Card(name, value));
        }
    }
    
    /**
     * Shuffles the calling DrawPile's deck and deals four Cards to each Player
     * Precondition: p1 and p2 have been initialized
     * Postcondition: the deck will have been shuffled and each Player will have
     * been given four cards
     * @param p1 - the Player in the game that will be dealt the first Card
     * @param p2 - the Player in the game that will be dealt the second Card
     */
    public void deal(Player p1, Player p2)
    {
        
        // Randomize order of Cards in deck
        Collections.shuffle((LinkedList) this.deck);
        
        // Give each Player four Cards from deck
        for (int i = 0; i < 4; i++)
        {
            p1.getHand().add(deck.poll());
            p2.getHand().add(deck.poll());
        }
    }
    
    /**
     * Pops all Cards from the discard pile submitted as a parameter, offers them
     * to the calling DrawPile's deck, and shuffles the deck.
     * Precondition: the discard pile has been initialized
     * Postcondition: all Cards in the discard pile will have been transferred to the deck
     * @param discard - the ArrayDeque the Players have been using to store their discarded cards
     */
    public void reload(ArrayDeque<Card> discard) 
    {
        
        // Obtain size of discard pile
        int size = discard.size();
        
        // Offer every Card in discard pile to deck
        for (int i = 0; i < size; i++)
        {
            deck.offer(discard.pop());
        }
        
        // Shuffle deck
        Collections.shuffle((LinkedList) deck);
    }
    
    /**
     * Returns the deck of the calling DrawPile.
     * Precondition: none
     * Postcondition: the deck of the DrawPile will have been returned
     * @return the DrawPile's deck
     */
    public LinkedList<Card> getDeck() 
    {
        return (LinkedList) this.deck;
    }
}
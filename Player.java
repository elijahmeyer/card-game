/*
 * Project 3 for CS 1181.
 * This program defines the Player class and all of its data fields and methods using the NetBeans IDE.
 * This program will represent and keep track of a player in the card game and store the 
 * methods necessary to monitor and manage the player's hand.
 */
package project3_meyer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author Elijah Meyer
 * CS1181L-C07
 * Dr. Cheatham
 * Project 3
 */
public abstract class Player 
{
    private ArrayList<Card> hand = new ArrayList<>();
    
    public Player()
    {
    } 
    
    /**
     * Returns the hand of the calling Player.
     * Precondition: none
     * Postcondition: the hand of the Player will have been returned
     * @return the Player's hand
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }
        
    public abstract int promptForDrawInput(ArrayDeque<Card> discard);
    
    public abstract int promptForDiscardInput(ArrayDeque<Card> discard);
    
    /**
     * Draws from the submitted discard pile or deck, depending on the value of the index submitted
     * as a parameter.
     * Precondition: index is 1 or 2; deck and discard have been initialized
     * Postcondition: a Card will have been added to the calling Player's hand from either the
     * discard pile or deck
     * @param index - a number indicating whether the Player wants to draw from the discard pile or deck
     * @param deck - the DrawPile the Players have been drawing from
     * @param discard - the ArrayDeque where the Players have been storing their discarded Cards
     */
    public void draw(int index, DrawPile deck, ArrayDeque<Card> discard)
    {
        // Draw Card from where index indicates: if 1, from discard pile, if 2, from deck
        if (index == 1)
        {
            
            // If caller is ComputerPlayer, output Card it picked up
            if (this instanceof ComputerPlayer)
            {
                System.out.println("I will pick up the " + discard.peek());
            }
            
            this.getHand().add(discard.pop());
        }
        
        // If caller drew from deck, inform them about what Card they drew
        else if (index == 2)
        {
            
            // Retrieve Card from deck
            Card c = deck.getDeck().poll();
            
            // If caller is ComputerPlayer, inform user of ComputerPlayer's move
            if (this instanceof ComputerPlayer)
            {
                System.out.println("I will draw a new card.");
            }
            
            // If caller is HumanPlayer, output what Card they drew
            else if (this instanceof HumanPlayer)
            {
                System.out.println("You drew the " + c);
            }
            this.getHand().add(c);
        }
    }
    
    /**
     * Removes the Card specified by the index from the calling Player's hand and pushes it to 
     * the submitted discard pile.
     * Precondition: the discard pile has been initialized; the first counting number is 1
     * Postcondition: a Card will have been removed from the Player's hand and pushed
     * onto the discard pile
     * @param index - the index in the Player's hand of the card to be removed (before adjusting
     * for ArrayLists starting at 0)
     * @param discard - the ArrayDeque to push the discarded Card onto
     */
    public void discard(int index, ArrayDeque<Card> discard)
    {
        
        // Adjust index count to reflect counting beginning with 0, remove Card at that index
        // from Player's hand, and push it onto discard pile
        discard.push(hand.remove(index - 1));
    }
    
    /**
     * Checks whether or not the Player has won (whether every Card in their hand has the
     * same value)
     * Precondition: hand size is 4
     * Postcondition: whether or not the Player has won the game will have been returned
     * @return whether or not the Player is victorious
     */
    public boolean isVictorious()
    {
        
        // Initialize counter variable
        int matchCount = 0;
        
        // Compare each Card with next Card in hand
        for (int i = 0; i < hand.size() - 1; i++)
        {
            if (hand.get(i).equals(hand.get(i + 1))) 
            {
                matchCount++;
            }
        }
        
        // Return whether or not all Cards in hand had the same value
        if (matchCount == 3)
        {
            return true;
        }
        return false;
    }
}
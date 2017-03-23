/*
 * Project 3 for CS 1181.
 * This program defines the ComputerPlayer class and all of its data fields and methods using the NetBeans IDE.
 * This program will implement all of the Player class's abstract methods to automate the manipulation of
 * the Player's hand, the deck, and the discard pile.
 */
package project3_meyer;

import java.util.ArrayDeque;

/**
 * @author Elijah Meyer
 * CS1181L-C07
 * Dr. Cheatham
 * Project 3
 */
public class ComputerPlayer extends Player 
{

    /**
     * Chooses whether the calling ComputerPlayer will draw from the deck or the discard pile
     * submitted as a parameter.
     * Precondition: discard has been initialized
     * Postcondition: an integer reflecting whether the ComputerPlayer will draw from the deck 
     * or the discard pile will have been returned
     * @param discard - the ArrayDeque where the Players have been storing their discarded Cards
     * @return the ComputerPlayer's decision about where to draw their next Card
     */
    @Override
    public int promptForDrawInput(ArrayDeque<Card> discard)
    {
        
        // Choose value and return
        return (int)(Math.random() * 2) + 1;
    }

    /**
     * Chooses which Card the calling ComputerPlayer will discard.
     * Precondition: discard is initialized
     * Postcondition: an integer reflecting which Card the ComputerPlayer will discard
     * will have been returned
     * @param discard - the ArrayDeque where the Players have been storing their discarded Cards
     * @return the ComputerPlayer's choice of what Card to discard
     */
    @Override
    public int promptForDiscardInput(ArrayDeque<Card> discard)
    {
        
        // Choose value
        int randomVar = (int)(Math.random() * 5) + 1;
        
        // Output decision and return
        System.out.println("I will discard the " + this.getHand().get(randomVar - 1));
        return randomVar;
    }
}
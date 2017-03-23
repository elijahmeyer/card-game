/*
 * Project 3 for CS 1181.
 * This program simulates a game of cards using the NetBeans IDE.
 * This program will prompt for input and use the input to manipulate a Queue
 * representing a deck of cards and a Stack simulating a discard pile. This program
 * will also simulate a computer player that will manipulate the deck and discard
 * pile in the same way.
 */
package project3_meyer;

import java.util.ArrayDeque;

/**
 * @author Elijah Meyer
 * CS1181L-C07
 * Dr. Cheatham
 * Project 3
 */
public class Project3_Meyer
{

    /**
     * Prompts the user for input regarding whether to draw from the deck or the discard
     * pile and draws accordingly, then prompts the user for input regarding which Card
     * to discard. Checks to see if the user has four Cards of the same value, then checks 
     * if the deck is empty. If it is, reloads the deck with Cards from the discard pile.
     * Does the same for the computer player, and repeats until one player has four Cards
     * of the same value.
     * Precondition: none
     * Postcondition: the user will have played a game of cards
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        // Initialize deck and discard pile
        DrawPile deck = new DrawPile();
        ArrayDeque<Card> discard = new ArrayDeque<>();
    
        // Initialize Players
        Player p1 = new HumanPlayer();
        Player p2 = new ComputerPlayer();
        
        // Deal four Cards to each Player
        deck.deal(p1, p2);
        
        // Make sure neither Player was dealt a winning hand, and begin loop
        while (!p1.isVictorious() && !p2.isVictorious())
        {
            // Ask user where to draw from, draw from there, and discard the Card the user specifies
            p1.draw(p1.promptForDrawInput(discard), deck, discard);
            p1.discard(p1.promptForDiscardInput(discard), discard);
            
            // Exit loop if user has four cards of the same value
            if (p1.isVictorious())
            {
                break;
            }
            
            // If deck is empty, put all Cards in discard pile into deck
            if (deck.getDeck().isEmpty())
            {
                deck.reload(discard);
            }
            
            // Draw and discard a Card for ComputerPlayer
            p2.draw(p2.promptForDrawInput(discard), deck, discard);
            p2.discard(p2.promptForDiscardInput(discard), discard);
            
            // If deck is empty, put all Cards in discard pile into deck
            if (deck.getDeck().isEmpty())
            {
                deck.reload(discard);
            }    
        } 
        
        // Inform user whether they have won or lost
        if (p1.isVictorious())
        {
            System.out.println("You win!");
        }
        
        else
        {
            System.out.println("I win!");
        }
    }
}
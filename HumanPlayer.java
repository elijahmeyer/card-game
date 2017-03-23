/*
 * Project 3 for CS 1181.
 * This program defines the HumanPlayer class and all of its data fields and methods using the NetBeans IDE.
 * This program will implement the Player class's abstract methods to prompt the user for input
 * and manipulate their hand, the deck, and the discard pile accordingly.
 */
package project3_meyer;

import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Elijah Meyer
 * CS1181L-C07
 * Dr. Cheatham
 * Project 3
 */
public class HumanPlayer extends Player 
{
    public HumanPlayer()
    {
    }
        
    /**
     * Prompts the user for input concerning whether to draw from the deck or the discard pile.
     * Precondition: discard has been initialized
     * Postcondition: an integer reflecting the user's decision about where to draw their next Card
     * from will have been returned
     * @param discard - the ArrayDeque where the Players have been storing their discarded Cards
     * @return - the user's choice of where to draw their next Card
     */
    @Override
    public int promptForDrawInput(ArrayDeque<Card> discard)
    {
        
        // Initialize variables
        Scanner input = new Scanner(System.in);
        boolean notDone = true;
        int choice = 0;
        
        do
        {
            
            // Output user's Cards
            System.out.println("Your cards are:");
            for (int i = 0; i < this.getHand().size(); i++)
            {
                System.out.println("\t" + this.getHand().get(i));
            }
            
            // Force user to draw from deck if discard pile is empty
            if (discard.isEmpty())
            {
                System.out.println("The discard pile is currently empty -- you must draw a card");
                return 2;
            }
            
            // If not, show Card on top of discard pile and obtain input
            else
            {
                System.out.println("The top card in the discard pile is the " + discard.peek());
            }
            System.out.print("Do you want to pick up the " + discard.peek() + " (1) or draw a card " +
            "(2)? ");
            try
            {
            choice = input.nextInt();
            
            // Exit loop if input is 1 or 2
            if (choice == 1 || choice == 2)
            {
                notDone = false;
            }
            
            // If not, tell user to enter 1 or 2
            else
            {
                System.out.println("Please enter either 1 or 2.");
            }
            
            // Catch if user entered something other than integer
            } catch (InputMismatchException ex)
            {
                System.out.println("Error: invalid input.");
                input.next();
            }
            
        // Continue loop until input is satisfactory, then return input
        } while (notDone);
        return choice;
    }

    /**
     * Prompts the user for input concerning which Card to discard.
     * Precondition: discard has been initialized
     * Postcondition: an integer reflecting which Card the user wants to discard
     * will have been returned
     * @param discard - the ArrayDeque where the Players have been storing their discarded Cards
     * @return the user's choice of which card to discard
     */
    @Override
    public int promptForDiscardInput(ArrayDeque<Card> discard)
    {
        
        // Initialize variables
        Scanner input = new Scanner(System.in);
        boolean notDone = true;
        int choice = 0;
        
        // Output user's Cards
        do
        {
            System.out.println("Now your cards are: ");
            for (int i = 0; i < this.getHand().size(); i++)
            {
                System.out.println("\t" + (i + 1) + ". " + this.getHand().get(i));
            }
        
            // Obtain user input
            System.out.print("Which one do you want to discard? ");
            try
            {
                choice = input.nextInt();
                
                // If input is an integer between one and five, exit loop
                if (choice >= 1 && choice <= 5)
                {
                    notDone = false;
                }
                
                // Inform user if input was unacceptable
                else
                {
                    System.out.println("Please enter an integer between 1 and 5.");
                }
                
            // Catch if user entered something other than integer    
            } catch (InputMismatchException ex)
            {
                System.out.println("Error: invalid input.");
                input.next();
            }
            
        // Repeat until input is acceptable, then return input
        } while (notDone);
        
        return choice;
    }   
}
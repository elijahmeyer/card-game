/*
 * Project 3 for CS 1181.
 * This program defines the ComputerPlayer class and all of its data fields and methods using the NetBeans IDE.
 * This program will implement all of the Player class's abstract methods to automate the manipulation of
 * the Player's hand, the deck, and the discard pile.
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
        
        int discardMatch = 0;
        for (int i = 0; i < this.getHand().size(); i++) 
        {
            if (this.getHand().get(i).equals(discard.peek()))
            {
                discardMatch++;
            }
        }
        
        if (discardMatch == 0)
        {
            return 2;
        }
                
        if (discardMatch == 1)
        {
            int handMatch = 0;
            for (int i = 0; i < this.getHand().size() - 1; i++)
            {
                if (this.getHand().get(i).equals(this.getHand().get(i + 1)))
                {
                    handMatch++;
                }
            }
            
            if (handMatch == 3) 
            {
                return 2;
            }
        }
        
        return 1;
    }

    /**
     * Chooses which Card the calling ComputerPlayer will discard.
     * Precondition: none
     * Postcondition: an integer reflecting which Card the ComputerPlayer will discard
     * will have been returned
     * @return the ComputerPlayer's choice of what Card to discard
     */
    @Override
    public int promptForDiscardInput()
    {
        
        // Initialize variables
        int valueToReturn = 0;
        int matchCount = 0;
        
        // Compare each Card in hand with the other Cards and record number of matches
        for (int i = 0; i < this.getHand().size(); i++)
        {
            for (int j = i; j < this.getHand().size(); j++)
            {
                if (this.getHand().get(i).equals(this.getHand().get(j)) && i != j)
                {
                    matchCount++;
                }
            }
        }
        
        // If there is at least one match...
        if (matchCount >= 1)
        {
            
            // Initialize variables
            Card c1 = this.getHand().get(0);
            Card c2 = this.getHand().get(1);
            Card c3 = this.getHand().get(2);
            Card c4 = this.getHand().get(3);
            Card c5 = this.getHand().get(4);
            
            // If there is one match...
            if (matchCount == 1)
            {
                
                // Compare each Card in hand to the other Cards, and record value of matching Cards
                int value = 0;
                for (int i = 0; i < this.getHand().size(); i++)
                {
                    for (int j = 0; j < this.getHand().size(); j++)
                    {
                        if (this.getHand().get(i).equals(this.getHand().get(j)) && i != j)
                        {
                            value = this.getHand().get(i).getValue();
                        }
                    }
                }
                
                // Find last Card in hand that does not match, and set valueToReturn to reference of that Card
                for (int i = 0; i < this.getHand().size(); i++) 
                {
                    if (this.getHand().get(i).getValue() != value) 
                    {
                        valueToReturn = i + 1;
                    }
                }
            }
            
            // If there are two pairs...
            else if (matchCount == 2)
            {
                
                // Count number of Cards that match first Card in hand
                int c1MatchCount = 0;
                for (int i = 1; i < this.getHand().size(); i++)
                {
                    if (c1.equals(this.getHand().get(i)))
                    {
                        c1MatchCount++;
                    }
                }
                
                // If no Cards match, set valueToReturn to 1 (Card 1 is odd man out) 
                if (c1MatchCount == 0)
                {
                    valueToReturn = 1;
                }
               
                else 
                {
                    
                    // Count number of Cards that match second Card in hand
                    int c2MatchCount = 0;
                    for (int i = 0; i < this.getHand().size(); i++)
                    {
                        if (c2.equals(this.getHand().get(i)) && i != 1)
                        {
                            c2MatchCount++;
                        }
                    }
                    
                    // If Card 2 is odd man out, set valueToReturn to 2
                    if (c2MatchCount == 0)
                    {
                        valueToReturn = 2;
                    }
                    
                    else
                    {
                        
                        // If Card 1 and Card 2 match...
                        if (c1.equals(c2))
                        {
                            
                            // Check if Card 3 is odd man out, and if so, set valueToReturn to 3
                            if (!c3.equals(c4) && !c3.equals(c5))
                            {
                                valueToReturn = 3;
                            }
                            
                            // If not, set valueToReturn to reference of Card that does not match Card 3
                            else 
                            {
                                for (int i = 3; i < this.getHand().size(); i++)
                                {
                                    if (!c3.equals(this.getHand().get(i))) 
                                    {
                                        valueToReturn = i + 1;
                                    }
                                }
                            }
                        }
                        
                        // If Card 1 and Card 2 do not match, set valueToReturn to reference of Card that matches neither of them
                        else 
                        {
                            for (int i = 0; i < this.getHand().size(); i++)
                            {
                                if (!c1.equals(this.getHand().get(i)) && !c2.equals(this.getHand().get(i)))
                                {
                                    valueToReturn = i + 1;
                                }
                            }
                        }
                    }
                }
            }
            
            // If there are three matching Cards, regardless of whether the other two match...
            else if (matchCount == 3 || matchCount == 4)
            {
                
                // Check how many Cards match first Card in hand
                int c1MatchCount = 0;
                for (int i = 1; i < this.getHand().size(); i++) 
                {
                    if (c1.equals(this.getHand().get(i)))
                    {
                        c1MatchCount++;
                    }
                }
                
                // If Card 1 is not part of the three of a kind, set valueToReturn to 1
                if (c1MatchCount < 2)
                {
                    valueToReturn = 1;
                }
                
                else
                {
                    
                    // Set valueToReturn to the reference of the last Card that did not match Card 1
                    int value = c1.getValue();
                    for (int i = 1; i < this.getHand().size(); i++) 
                    {
                        if (this.getHand().get(i).getValue() != value) 
                        {
                            valueToReturn = i + 1;
                        }
                    }
                }
            }
            
            // If four Cards match...
            else if (matchCount == 6)
            {
                
                // If first Card in hand does not match two other Cards, set valueToReturn to 1 (Card 1 is odd man out)
                if (!c1.equals(c2) && !c1.equals(c3))
                {
                    valueToReturn = 1;
                }
                
                // Otherwise, set valueToReturn to reference of Card that does not match Card 1
                int value = c1.getValue();
                for (int i = 1; i < this.getHand().size(); i++)
                {
                    if (this.getHand().get(i).getValue() != value)
                    {
                        valueToReturn = i + 1;
                    }
                }
            }
        }
        
        // If there are no matches...
        else
        {
            // Set valueToReturn to random value
            valueToReturn = (int)(Math.random() * 5) + 1;
        }
        
        // Output decision and return chosen value
        System.out.println("I will discard the " + this.getHand().get(valueToReturn - 1));
        return valueToReturn;
    }
}
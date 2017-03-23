/*
 * Project 3 for CS 1181.
 * This program defines the Card class and all of its data fields and methods using the NetBeans IDE.
 * This program will represent and keep track of an individual card in the game.
 */
package project3_meyer;

/**
 * @author Elijah Meyer
 * CS1181L-C07
 * Dr. Cheatham
 * Project 3
 */
public class Card
{
    private String name;
    private int value;
    
    public Card(String name, int value)
    {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the name of the calling Card.
     * Precondition: none
     * Postcondition: the name of the Card will have been returned
     * @return the Card's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the value of the calling Card.
     * Precondition: none
     * Postcondition: the value of the Card will have been returned
     * @return the Card's value
     */
    public int getValue() 
    {
        return value;
    }
    
    /**
     * Returns the calling Card's name.
     * Precondition: none
     * Postcondition: the name of the Card will have been returned
     * @return the Card's name
     */
    @Override
    public String toString()
    {
        return this.name;
    }

    /**
     * Determines whether or not the Object submitted as a parameter is equal to
     * the calling Card, with respect to the Card's value.
     * Precondition: none
     * Postcondition: whether the Card is equal to the Object will have been 
     * returned
     * @param obj - the Object being compared to the calling Card
     * @return whether or not the Object and the card are equal
     */
    @Override
    public boolean equals(Object obj)
    {
        
        // Check if Card and Object point to same memory location, and return true if so
        if (this == obj) 
        {
            return true;
        }
        
        // Check if Object is null, and return false if so
        if (obj == null) 
        {
            return false;
        }
        
        // Check if Object is a Card, and return false if not
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        
        // Type cast Object to a Card
        final Card other = (Card) obj;
        
        // Return whether or not Card and Object share the same value
        if (this.value != other.value) 
        {
            return false;
        }
        
        return true;
    }
}
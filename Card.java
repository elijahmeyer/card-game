/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_meyer;

/**
 *
 * @author Elijah
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

    public String getName()
    {
        return name;
    }

    public int getValue() 
    {
        return value;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
}
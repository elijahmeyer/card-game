/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_meyer;

import java.util.ArrayList;

/**
 *
 * @author Elijah
 */
public abstract class Player 
{
    private ArrayList<Card> hand;
    
    public Player()
    {
    } 
   
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    
    public abstract void draw();
    
    public abstract void discard();
}
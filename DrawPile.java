/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_meyer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Elijah
 */
public class DrawPile 
{
    private Queue<Card> deck = new LinkedList();
    
    public DrawPile()
    {
        for (int i = 0; i < 52; i++)
        {
            String name = "";
            int value = (i % 13) + 1;
            
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
            
            deck.offer(new Card(name, value));
        }
    }
    
    public void deal(Player p1, Player p2)
    {
        Collections.shuffle((LinkedList) this.deck);
        for (int i = 0; i < 4; i++)
        {
            p1.getHand().add(deck.poll());
            p2.getHand().add(deck.poll());
        }
    }
    
    @Override
    public String toString() {
        int size = deck.size();
        String message = "";
        for (int i = 0; i < size; i++)
        {
            message += deck.poll().toString() + "\n";
        }
        return message;
    }
}
package Assignment1;

/*
 * Andrew Chow
 * CSC 103
 * 10/7/2016
 */


import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Hand
{
	private ArrayList<Card> hand = new ArrayList<Card>();
	private Deck deck;
	
	public Hand(Deck deck, int handSize)
	{
		if( handSize <= 0)
		{
			throw new IllegalArgumentException();
		}
		if( deck == null)
		{
			throw new NullPointerException();			
		}
		
		if( deck.size() < handSize)
		{
			throw new NoSuchElementException();
		}
		
		for( int i = 0; i < handSize; i++)
		{
			hand.add(deck.draw());
		}	
		
		this.deck = deck;
	}
	// Draws from the deck class
	public void draw()
	{
		if(deck.size() == 0)
		{
			throw new NoSuchElementException();
		}
		
		hand.add(deck.draw());
	}
	// Returns the card at the cardNumber index position
	public Card getCard(int cardNumber)
	{
		if (cardNumber < 0 || cardNumber >= hand.size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		return hand.get(cardNumber);
		
	}
	// Plays a card then removes it from hand at cardNumber index position
	public Card play(int cardNumber)
	{
		if (cardNumber < 0 || cardNumber >= hand.size())
		{
			throw new IndexOutOfBoundsException();
		}
		Card temp = hand.get(cardNumber);
		hand.remove(cardNumber);
		return temp;
		
	}
	// Returns Size
	public int size()
	{
		return hand.size();		
	}
	
}


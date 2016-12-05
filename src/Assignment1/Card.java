package Assignment1;

/*
 * Andrew Chow
 * CSC 103
 * 10/7/2016
 */
public class Card {

	private String[] cardRanks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	private String[] cardSuits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	
	private int rank;
	private int suit;

	
	//Constructs a card with the specified rank and suit. Rank is 1 to 13 from "Ace", "Two" ... to "King". Suits are 1 to 4 "Spades" , "Hearts",
	// Diamonds", and "Clubs" in that order.
	public Card(int rank, int suit)
	{
		if(rank < 1 || rank > 13)
		{
			throw new IllegalArgumentException();
		}
		
		else if(suit < 1 || suit > 4)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.rank = rank;
			this.suit = suit;
		}
	}
	
	//Returns the rank
	public String getRank()
	{
		return cardRanks[rank-1];	
	}
	
	//Returns the suit
	public String getSuit()
	{
		return cardSuits[suit-1];
	}	
	
	//Returns the card
	public String toString()
	{
		return (getRank() + " of " + getSuit());
	}
}

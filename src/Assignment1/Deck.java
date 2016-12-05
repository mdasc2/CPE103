package Assignment1;

/*
 * Andrew Chow
 * CSC 103
 * 10/7/2016
 */
import java.util.NoSuchElementException;
import java.util.Random;

public class Deck extends CircularQueue<Card>
{
	// Initializes all 52 cards of a standard deck
	public Deck(boolean shuffle)
	{
		
		super(52);		
		for(int i = 1; i < 5; i++)
		{
			for(int j = 1; j < 14; j++)
			{
				Card newCard = new Card(j,i);
				enqueue(newCard);
			}
		}		
		if(shuffle == true)
		{
			shuffle();
		}
	}
	
	// Mixes up all the cards in the Deck
	public void shuffle()
	{		
		Card tempCards[] = new Card[this.size()];
		Card cardHolder;
		
		Random rand = new Random();		
		int swapIndex;
		
		for(int i = 0; i < this.size(); i++)
		{
			tempCards[i] = dequeue();
		}
		
		for(int i = 0; i < this.size(); i++)
		{
			swapIndex = rand.nextInt(this.size());
			
			cardHolder = tempCards[i];			
			tempCards[i]= tempCards[swapIndex];
			tempCards[swapIndex] = cardHolder;
		}
		
		for(int i = 0; i < 52; i++)
		{
			enqueue(tempCards[i]);
		}
	}
	// Takes a card from the top of the deck
	public Card draw()
	{
		
		if(size() == 0)
		{
			throw new NoSuchElementException();
		}
		
		return dequeue();
	}
		
}	



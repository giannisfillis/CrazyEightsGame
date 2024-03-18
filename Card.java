// Giannis Fillis A.M : 5380
class Card
{
	private String suit;
	private int number;
	
	public Card(String suit,int number){
		this.suit = suit;
		this.number = number;
	}
	
	public String getSuit(){ //accessor gia to xroma
		return suit;
	}
	
	public void setSuit(String suit){ //mutator gia to xroma
		this.suit = suit;
	}
	
	public String toString(){ 
		return number + " " + suit;
	} 
	
	public Boolean isEight(){ //epistrefei true an to fyllo einai 8
		if (number == 8)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean matches(Card other){
		if ((this.number == other.number) || this.suit.equals(other.suit))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
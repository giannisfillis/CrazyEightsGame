// Giannis Fillis A.M : 5380

import java.util.ArrayList;
import java.util.Random;

class Pile
{
	private ArrayList<Card> pile = new ArrayList<Card>(); //h trapoula
	private Card cardItem; //ena fyllo
	private String[] suits = {"S","H","C","D"};
	private int[] numbers = {0,1,2,3,4,5,6,7,8,9}; //ta noumera pou pernoun ta fylla
	Random randomPosition = new Random();//epilegei thn tyxaia thesi
	int randomNumber1; //tyxaios arithmos
	int randomNumber2; //tyxaios arithmos
	
	public void fill(){ //gemizei thn trapoula
		for (int suit=0;suit<4;suit++){
			for (int number=0;number<10;number++){
				pile.add(new Card(suits[suit],number));
				
			}
		}
		shuffle();
	}
	
	public void fill(ArrayList<Card> Cards){ //gemizei thn trapoula me vazei kapoio arraylist pou tha dothei
		for (int i=0;i<Cards.size();i++){
			pile.add(Cards.get(i));
		}
		shuffle();
	}
	
	private void shuffle(){ //anakateyei thn trapoula
		for (int i=0;i<1500;i++){
			randomNumber1 = randomPosition.nextInt(pile.size());
			randomNumber2 = randomPosition.nextInt(pile.size());
			cardItem = pile.get(randomNumber1);
			pile.set(randomNumber1,pile.get(randomNumber2));
			pile.set(randomNumber2,cardItem);
		}
	}
	
	 public Card nextCard() //afairei to xarti apo tin koryfh tis stoivas
	{
		if (isEmpty())
		{
			fill();
			Card tempCard1 = pile.get(pile.size()-1);
			pile.remove(pile.get(pile.size()-1));
			return tempCard1;
		}
		else
		{
			Card tempCard2 = pile.get(pile.size()-1);
			pile.remove(pile.get(pile.size()-1));
			return tempCard2;
		}
	} 
	
	public Boolean isEmpty() //elegxei an einai adeia h stoivas
	{
		if (pile.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	} 
	
	public void print() //kanei print tin stoiva 
	{
		String finalArray = "[ ";
		for (Card card : pile){
			System.out.print(card + " ");
		}
	} 
	
	
	public static void main(String[] args){
		String[] suitss = {"S","H","C","D"};
		int[] numberss = {0,1,2,3,4,5,6,7,8,9};
		Pile trapoula1 = new Pile();
		Pile trapoula2 = new Pile();
		System.out.println("The pile is empty : " + trapoula1.isEmpty());
		trapoula1.fill();
		System.out.println("The pile is empty : " + trapoula1.isEmpty());
		trapoula1.print();
		System.out.println("and the second one");
		ArrayList<Card> myArray = new ArrayList<Card>();
		for (int i=0;i<4;i++)
		{
			myArray.add(new Card(suitss[i],numberss[i]));
		}
		trapoula2.fill(myArray); 
		trapoula2.print();
		System.out.println("the nextcard is ");
		System.out.println(trapoula1.nextCard());
		System.out.println("and the final pile is ");
		trapoula1.print();
	} 
}
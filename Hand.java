// Giannis Fillis A.M : 5380

import java.util.ArrayList;
import java.util.HashMap;

class Hand
{
	private ArrayList<Card> myHand;
	private HashMap<String,Integer> amountOfSuits = new HashMap<String,Integer>();
	private String[] suits = {"S","H","C","D"};
	
	public Hand(){
		myHand = new ArrayList<Card>();
		for (int i=0;i<4;i++) 
		{
			amountOfSuits.put(suits[i],0);
		}
	}
	
	public void printHashMap(){ //voithitiki methodos
		for(String w: amountOfSuits.keySet()){
		System.out.println(w+":"+amountOfSuits.get(w));
		}
		System.out.println("and the size is " + amountOfSuits.size());
	}
	
	public void addCard(Card card){  //prosthetei sto xeri to card
		String suit = card.getSuit();
		if (!card.isEight()){
			amountOfSuits.put(suit,amountOfSuits.get(suit)+1);
		}	
		myHand.add(card);
	}
	
	
	public void removeCard(Card card){   //afairei ena xarti apo to xeri
		String suit = card.getSuit();
		if (!card.isEight()){
			amountOfSuits.put(suit,amountOfSuits.get(suit)-1);
		}
		myHand.remove(card);
	}
	
	
	public Card getCard(int i){  // pernei san orisma mia thesi kai epistrefei to xarti se ayth thn thesi
		if ((i>myHand.size()-1) || (i<0))
		{
			return null;
		}
		else
		{
			return myHand.get(i);
		}
	}
	
	
	public void printHand(){
		for (int i=0;i<myHand.size();i++)
		{
			System.out.print(i + "	");
		}
		System.out.println(" ");
		for (int i=0;i<myHand.size();i++)
		{
			System.out.print(myHand.get(i) + "	");
		}
		System.out.println(" ");
	}
	
	
	public Boolean isEmpty(){
		if (myHand.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int NumberOfCards(){ //voithitiki methodos
		return myHand.size();
	}
	
	public Card findMatchingCard(Card cardOnTheTable){
		Card FinalCard; //to xarti pou tha epilexthei
		Card myCard; //xrisimopoieitai gia na elegxo ta ypopsifia xartia
		ArrayList<Card> possibleCards = new ArrayList<Card>(); //h lista me ta pithana xartia gia na rixei
		ArrayList<Card> cardsWithEight = new ArrayList<Card>();
		for (int i=0;i<myHand.size();i++){ //ayto to loop xrisimeyei gia na gemisoun ta dyo ArrayLists
			myCard = myHand.get(i);
			if (myCard.matches(cardOnTheTable) && !myCard.isEight()){ 
				possibleCards.add(myCard);
			}
			else if (myCard.isEight()){
				cardsWithEight.add(myCard);
			}
		}
		if (possibleCards.size() !=0){ //an yparxoun pithana xartia ektos apo 8
			Card tempCard1 = possibleCards.get(0); //to proto pithano xarti
			for (int i=1;i<possibleCards.size();i++){
				if (amountOfSuits.get(tempCard1.getSuit())<amountOfSuits.get(possibleCards.get(i).getSuit())){ //elegxei an einai to proigoumeno mikrotero xarti apo to epomeno
					tempCard1 = possibleCards.get(i);
				}
			}
			FinalCard = tempCard1;
			return FinalCard;
		}
		else if ((possibleCards.size() == 0) && (cardsWithEight.size() != 0)){ //an den yparxoun pithana xartia alla yparxei 8
			FinalCard = cardsWithEight.get(0);
			String tempCard2 = suits[0]; //to proto pithano xroma
			for (String alpha : amountOfSuits.keySet()){
				if (amountOfSuits.get(tempCard2)< amountOfSuits.get(alpha)){
					tempCard2 = alpha;
				}
			}
			FinalCard.setSuit(tempCard2);
			return FinalCard;
		}
		else{ //an dn yparxei xarti na rixei
			return null;
		}
	}
	
	 public static void main(String[] args){
		Hand Hand1 = new Hand();
		//Hand1.printHashMap();
		Card myCard1 = new Card("S",1);
		Card myCard2 = new Card("C",8);
		Card myCard3 = new Card("C",3);
		Card myCard4 = new Card("H",2);
		Card myCard5 = new Card("H",6);
		Hand1.addCard(myCard1);
		Hand1.addCard(myCard2);
		Hand1.addCard(myCard3);
		Hand1.addCard(myCard4);
		Hand1.addCard(myCard5);
		//Hand1.removeCard(myCard2);
		Card CardDown = new Card("D",9);
		System.out.println("To xarti pou epilextike einai " + Hand1.findMatchingCard(CardDown));
		Hand1.printHashMap();
	} 
}
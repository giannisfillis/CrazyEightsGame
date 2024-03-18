// Giannis Fillis A.M : 5380

import java.util.Scanner;

class Player
{
	private String PlayerName; //onoma paikti
	private Hand PlayerHand = new Hand(); //to xeri tou paikti
	Scanner input = new Scanner(System.in);
	
	public Player(String PlayerName){ //o constructor me to onoma tou paikti
		this.PlayerName = PlayerName;
	}
	
	public void draw(Table myTable){ //pernei ena xarti apo to table
		myTable.drawCard(); 
		PlayerHand.addCard(myTable.drawCard());
	}
	
	public void draw(Table myTable,int numberOfCards){ //pernei ena xarti apo to table kai to prosthetei ston paikti
		for (int i=0;i<numberOfCards;i++){ 
			Card drawnCard = myTable.drawCard();
			PlayerHand.addCard(drawnCard);
		}
	}
	
	public void throwCard(Table myTable,Card cardOfChoice){ //rixnei xarti sto table kai to afairei apo ton paikti
		myTable.throwCard(cardOfChoice);
		PlayerHand.removeCard(cardOfChoice);
	}
	
	public Boolean isDone(){  //elegxei an teleiosan ta xartia tou paikti
		if(PlayerHand.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){ //epistrefei to onoma tou paikti
		return PlayerName;
	}
	
	public Card selectCard(Table myTable){			
		Card myCard1;
		PlayerHand.printHand(); 
		System.out.println("Choose one card or type -1 if you want to pass : ");
		int response = input.nextInt();
		if (response == -1){
			return null;
		}
		else if (PlayerHand.getCard(response).isEight()){
			System.out.print("Choose a suit: ");
			String SuitResponse = input.next();
			myCard1 = PlayerHand.getCard(response);
			myCard1.setSuit(SuitResponse);
			return myCard1;
		}
		else{
			while (!PlayerHand.getCard(response).matches(myTable.getTopCard())){
				System.out.println("No matching cards found,try again ");
				System.out.println("Choose one card or type -1 if you want to pass: ");
				response = input.nextInt();
				if (response == -1){
					return null;
				}
				else if (PlayerHand.getCard(response).isEight()){
					System.out.print("Choose a suit: ");
					String SuitResponse = input.nextLine();
					myCard1 = PlayerHand.getCard(response);
					myCard1.setSuit(SuitResponse);
					return myCard1;
				}
			}
			return PlayerHand.getCard(response);
		}
	}
	
	public Card computerSelectCard(Table myTable){
		//PlayerHand.printHand(); ektiponei to xeri tou paikti
		Card ComputerCard = PlayerHand.findMatchingCard(myTable.getTopCard());
		if (ComputerCard == null){
			return null; //diladi tha xanei thn seira tou(epilegei paso)
		}
		else{
			return ComputerCard; //allios apla epistrefei tin katallilh karta
		}
	}
	
	public static void main(String[] args){
		Player myPlayer = new Player("Giannis");
		Table table1 = new Table();
		myPlayer.draw(table1);
		myPlayer.draw(table1);
		myPlayer.draw(table1);
		myPlayer.PlayerHand.printHand();
		myPlayer.draw(table1,2);
		myPlayer.PlayerHand.printHand();
		myPlayer.throwCard(table1,myPlayer.PlayerHand.getCard(0));
		myPlayer.PlayerHand.printHand();
		System.out.println(myPlayer.isDone());
		System.out.println(myPlayer);
		System.out.println(myPlayer.selectCard(table1)); //exo to print gia na vlepo ti epistrefei
		System.out.println(myPlayer.computerSelectCard(table1)); //exo to print gia na vlepo ti epistrefei
	} 
}
	
	
	

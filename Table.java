// Giannis Fillis A.M : 5380

import java.util.ArrayList;

class Table
{
	private Pile pile; //to antikeimeno tis stoibas
	private ArrayList<Card> thrownCards = new ArrayList<Card>(); //i lista me ta xartia pou exoun petaxtei
	private Card topCard; //to topcard to opoio arxikopoieitai os to proto xarti pano sto table
	
	public Table()
	{
		pile = new Pile(); //dimiourgia tis stoivas
		pile.fill(); 
		topCard = pile.nextCard(); //to topcard einai arxika to proto fyllo pou peftei sto trapezi(to xarti apo tin koryfh ths stoivas
	}
	
	public void throwCard(Card card) //to xarti pou rixnoume
	{
		thrownCards.add(card); //to prosthetoume sthn lista me ta petamena xartia
		topCard = card; //tora to topCard einai to poio prosfato xarti pou petaxtike
	} 
	
	public Card drawCard() //to xarti pou pairnoume apo tin stoiva
	{
		if (!pile.isEmpty())
		{
			return pile.nextCard();
		}
		else
		{
			pile.fill(thrownCards);
			return pile.nextCard();
		}
	}
	
	public Card getTopCard() //accessor gia to teleytaio xarti
	{
		return topCard;
	}
	
	public void printThrownCards(){ //voithitiki methodos
		for (int j=0;j<thrownCards.size();j++){
			System.out.println(thrownCards.get(j));
		}
	}
	
	public static void main(String[] args){
		//Card card1 = new Card();
		Table table = new Table();
		for (int i=1;i<41;i++)
		{
			table.drawCard();
			System.out.println( " to drawn card einai to " + table.drawCard());
			table.getTopCard();
			if ( (i%2)==0)
			{
				table.throwCard(table.drawCard());
				System.out.println("to top card einai to " + table.getTopCard());
			}
		}
		//table.printThrownCards();
	} 
}
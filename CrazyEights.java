// Giannis Fillis A.M : 5380

class CrazyEights
{ 
	private Table PlayTable = new Table();
	private int NumberOfPlayers;
	private Player[] Players; 
	
	public CrazyEights(int NumberOfPlayers1){
		this.NumberOfPlayers = NumberOfPlayers1;
		Players = new Player[NumberOfPlayers];
		for (int i=0;i<NumberOfPlayers;i++){
			if (i==0){
				Players[i] = new Player("Human");
			}
			else{
				Players[i] = new Player("Computer " + i);

			}
		}
	}
	
	
	public void play(){
		Table PlayTable =new Table();
		int j=0;
		for (int i=0;i<NumberOfPlayers;i++){ //oi paiktes pernoun xartia
			Players[i].draw(PlayTable,5);
		} 
		while (true){
			if (j==0){
				System.out.println("Table's top card " + PlayTable.getTopCard());
				System.out.println("Human's turn: ");
				Card SelectedCard = Players[0].selectCard(PlayTable);
				if (SelectedCard == null){
					Players[0].draw(PlayTable);
				}
				else{
					Players[0].throwCard(PlayTable,SelectedCard);
				}
				j++;
			}
			else{
				System.out.println("Computer's turn: ");
				Card computerCard = Players[j].computerSelectCard(PlayTable);
				if (computerCard == null){
					System.out.println("Computer chose pass ");
					System.out.println();
					Players[j].draw(PlayTable);
				}
				else{
					Players[j].throwCard(PlayTable,computerCard);
					System.out.println("Computer threw card : " + computerCard);
					System.out.println();
				}
				j++;
			}
			if (j==NumberOfPlayers){
				j=0;
			}
			for (int i = 0; i<NumberOfPlayers;i++){ //elegxei an kapoios nikise
				if (Players[i].isDone()){
				System.out.println(Players[i] + " won");
				return;
			}
		}
		}
	}
	
}
// Giannis Fillis A.M : 5380

import java.util.Scanner;

class Game
{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please give number of players");
		int number = input.nextInt();
		while (number<=1 || number >7){
			System.out.println("Please give a number of players between 2 and 7");
			number = input.nextInt();
		}
		CrazyEights game1 = new CrazyEights(number);
		game1.play();
	}
}
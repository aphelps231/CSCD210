package fileIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*	Andrew Phelps - Rock Paper Scissors
 * 	March 13th, 2017
 * 	Shortcomings:calculating winners of each round
 * 	Extra credit: none attempted 
 */

public class RockPaperScissors
{
	static RPSGame[][] arr;
	
	public static void main(String[] args) throws IOException
	{
		readInputFile();
		writeOutput();
	}
	
	public static void readInputFile() throws IOException
	{
		Scanner fin = new Scanner(new File("a.txt"));
		
		int numRounds = fin.nextInt();
		int numGames = fin.nextInt();
		String choiceOne, choiceTwo, input;
		
		arr = new RPSGame[numRounds][];
		
		for(int i = 0; i < numRounds && fin.hasNextLine(); i++)
		{
			fin.nextLine();
			
			arr[i] = new RPSGame[numGames];
			
			for(int j = 0; j < numGames && fin.hasNextLine(); j++)
			{
				input = "" + fin.nextLine();

				choiceOne = input.split(" ")[0];
				choiceTwo = input.split(" ")[1];
				
				arr[i][j] = new RPSGame(choiceOne, choiceTwo);
			}
			
			if(fin.hasNextLine())
			{
				numGames = fin.nextInt();
			}
		}
		
		fin.close();
	}
	
	public static void writeOutput()
	{
		int winner;
		
		for(int i = 0; i < arr.length; i++)
		{
			winner = RPSGame.calcWinner(arr[i]);
			
			System.out.println(winner == 0 ? "TIE" : winner == 1 ? "PLAYER TWO" : "PLAYER ONE");
		}
	}
}

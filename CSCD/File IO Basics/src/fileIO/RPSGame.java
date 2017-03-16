package fileIO;

public class RPSGame
{
	private String playerOneChoice, playerTwoChoice;
	private int winner;
	
	public RPSGame(String pOne, String pTwo)
	{
		this.playerOneChoice = pOne.toUpperCase();
		this.playerTwoChoice = pTwo.toUpperCase();
		
		calcWinner();
	}
	
	public int getWinner()
	{
		return this.winner;
	}
	
	private int calcWinner() // p1 = -1 tie = 0 p2 = 1
	{
		int score = 0;
		
		if(this.playerOneChoice.contains("R"))
		{
			if(this.playerTwoChoice.contains("R"))
			{
				score = 0;
			}
			else if(this.playerTwoChoice.contains("P"))
			{
				score = 1;
			}
			else if(this.playerTwoChoice.contains("S"))
			{
				score = -1;
			}
		}
		else if(this.playerOneChoice.contains("P"))
		{
			if(this.playerTwoChoice.contains("R"))
			{
				score = -1;
			}
			else if(this.playerTwoChoice.contains("P"))
			{
				score = 0;
			}
			else if(this.playerTwoChoice.contains("S"))
			{
				score = 1;
			}
		}
		else if(this.playerOneChoice.contains("S"))
		{
			if(this.playerTwoChoice.contains("R"))
			{
				score = 1;
			}
			else if(this.playerTwoChoice.contains("P"))
			{
				score = -1;
			}
			else if(this.playerTwoChoice.contains("S"))
			{
				score = 0;
			}
		}
		
		return score;
	}
	
	public static int calcWinner(RPSGame[] arr)
	{
		int wins = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			wins += arr[i].calcWinner();
		}
		
		return wins == 0 ? 0 : wins > 0 ? 1 : -1;
	}
	
	public String toString()
	{
		return this.winner + ", " + this.playerOneChoice + ", " + this.playerTwoChoice;
	}
}

package pascalsTriangle;

public class PascalTester
{
	public static void main(String[] args)
	{
		printTriangle(fillTriangle(15));
	}
	
	public static int[][] fillTriangle(int a)
	{
		a -= ((a - 1) % 2);
		
		int triangle[][] = new int[a][a * 2];
		
		for(int i = 0; i < triangle.length; i++)
		{
			int spaces = ((2 * a) - (2 * i)) / 2;
			int nums = i + 1;
			
			for(int j = 0; j < spaces; j++)
			{
				triangle[i][j] = 0;
			}
			
			for(int k = spaces; k < spaces + (2 * nums) - 1; k++)
			{
				if((k + (i % 2)) % 2 == 1)
				{
					if(k == spaces || k == spaces + (2 * nums) - 2)
					{
						triangle[i][k] = 1;
					}
					else
					{
						triangle[i][k] = triangle[i - 1][k - 1] + triangle[i - 1][k + 1];
					}
				}
				else
				{
					triangle[i][k] = 0;
				}
			}
			
			for(int l = spaces + (2 * nums); l < triangle[i].length; l++)
			{
				triangle[i][l] = 0;
			}
		}
		
		return triangle;
	}
	
	public static void printTriangle(int[][] triangle)
	{
		boolean inTriangle = false;
		
		for(int i = 0; i < triangle.length; i++)
		{
			inTriangle = false;
			
			for(int j = 0; j < triangle[i].length; j++)
			{
				if(triangle[i][j] == 1)
				{
					inTriangle = true;
				}
				
				if(inTriangle && triangle[i][j] == 0)
				{
					System.out.print("\t\t");
				}
				else if(triangle[i][j] == 0 && j != 0)
				{
					System.out.print("\t");
				}
				else if(j != 0)
				{
					System.out.print(triangle[i][j]);
				}
			}
			
			System.out.println("\n\n");
		}
	}
}

package lesson;

public class Printf
{
	public static void main(String[] args)
	{
		int myInt = 12;
		double myDouble = 12.6789;
		
		System.out.printf("regular: %d \n", myInt); //%d == integer
		System.out.printf("left justify: %-20d \n", myInt); //%-20d == put number and 20 spaces after
		System.out.printf("right justify: %20d \n", myInt); //%20d == put 20 spaces and number after
		System.out.printf("right justify, pad with zeros: %020d \n", myInt); //%020d == put 20 zeros and number after
		System.out.printf("three decimal places: %20.3f \n", myDouble);
		System.out.printf("dollar sign: $%20f", myDouble);
	}
}

package rentalRates;

public class RentalRates
{
	public static Rate	rateBest,
						rateOne,
						rateTwo,
						rateThree;
	
	public static void main(String[] args)
	{
		
	}
	
	public static void createRanges()
	{
		Rate tmp = new Rate(0, 0);
		
		int[] tmpMale = {33, 65},
			  tmpFemale = {30, 62};
		
		rateBest = new Rate(tmpMale, tmpFemale, 200, 40, tmp);
		
		int[] tmpMale1 = {0, 0},
			  tmpFemale1 = {25, 29};
		
		rateOne = new Rate(tmpMale1, tmpFemale1, 55, 10, rateBest);
		
		int[] tmpMale2 = {25, 32},
			  tmpFemale2 = {0, 0};
		
		rateTwo = new Rate(tmpMale2, tmpFemale2, 30, 7, rateOne);
		
		
	}
}

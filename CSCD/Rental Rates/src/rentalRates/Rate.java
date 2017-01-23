package rentalRates;

public class Rate
{
	private int[] ageRange;
	
	private int weeklyCost,
				dailyCost,
				baseWeeklyCost,
				baseDailyCost;
	
	public Rate(int weekly, int daily)
	{
		this.weeklyCost = weekly;
		this.dailyCost = daily;
	}
	
	public Rate(int[] maleAgeRange, int[] femaleAgeRange, int weekly, int daily, Rate baseRate)
	{
		for(int i = 0; i < 2; i++)
		{
			this.ageRange[i] = maleAgeRange[i];
			this.ageRange[i + 2] = femaleAgeRange[i];
		}
		
		this.weeklyCost = weekly;
		this.dailyCost = daily;
		this.baseWeeklyCost = baseRate.getWeeklyCost();
		this.baseDailyCost = baseRate.getDailyCost();
	}
	
	public int getWeeklyCost()
	{
		return this.weeklyCost + this.baseWeeklyCost;
	}
	
	public int getDailyCost()
	{
		return this.dailyCost + this.baseDailyCost;
	}
	
	public int[] getAgeRange()
	{
		return this.ageRange;
	}
}

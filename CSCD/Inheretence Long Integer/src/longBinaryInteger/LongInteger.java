package longBinaryInteger;

public class LongInteger
{
	protected String value;
	
	protected int BASE;
	
	public LongInteger(Long val)
	{
		this.BASE = 10;
		
		this.value = val.toString();
	}
	
	public LongInteger()
	{
		this((long) 1);
	}
	
	public Long getValue()
	{
		return Long.parseLong(this.value, this.BASE);
	}
	
	public int getBase()
	{
		return this.BASE;
	}
	
	public LongInteger add(LongInteger other)
	{
		return new LongInteger(this.getValue() + other.getValue());
	}
	
	public LongInteger subtract(LongInteger other)
	{
		return new LongInteger(this.getValue() - other.getValue());
	}
	
	public LongInteger multiply(LongInteger other)
	{
		return new LongInteger(this.getValue() * other.getValue());
	}
	
	public LongInteger divide(LongInteger other)
	{
		return new LongInteger(this.getValue() / other.getValue());
	}
	
	public static String convert(long num, int base)
	{
	    long quotient = num / base;
	    long remainder = num % base;

	    if (quotient == 0)
	    {
	        return Long.toString(remainder);      
	    }
	    else
	    {
	        return convert(quotient, base) + Long.toString(remainder);
	    }            
	}
	
	public String toString()
	{
		return this.value;
	}
}

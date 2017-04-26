package longBinaryInteger;

public class BinaryInteger extends LongInteger
{
	public BinaryInteger(Long val)
	{
		this.BASE = 2;
		
		this.value = val.toString();
	}
	
	public BinaryInteger()
	{
		this((long) 1);
	}
}

package longBinaryInteger;

public class HexInteger extends LongInteger
{
	public HexInteger(Long val)
	{
		this.BASE = 16;
		
		this.value = val.toString();
	}
	
	public HexInteger()
	{
		this((long) 1);
	}
}

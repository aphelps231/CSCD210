package longBinaryInteger;

public class OctalInteger extends LongInteger
{
	public OctalInteger(Long val)
	{
		this.BASE = 8;
		
		this.value = val.toString();
	}
	
	public OctalInteger()
	{
		this((long) 1);
	}
}

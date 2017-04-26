package longBinaryInteger;

import java.util.ArrayList;

/*	Andrew Phelps - Long Integers
 * 	April 25th, 2017
 * 	Shortcomings: hex conversions	
 * 	Extra credit: attempted, in LongInteger.java and LongIntegerDriver.java
 */

public class LongIntegerDriver
{
	public static MenuUtil menu;
	
	public static String output;
	public static String mode;
	public static String operation;
	
	public static LongInteger a;
	public static LongInteger b;
	
	public static int base;
	
	public static void main(String[] args)
	{
		init();
		
		while(!mode.equals("q"))
		{
			run();
		}
	}
	
	public static void init()
	{
		ArrayList<String> menuArr = new ArrayList<String>();
		
		menuArr.add("bin - Binary\t\t+");
		menuArr.add("oct - Octal\t\t-");
		menuArr.add("dcm - Decimal\t\t*");
		menuArr.add("hex - Hexadecimal\t/");
		menuArr.add(" q  - Quit\t\t=");
		
		menu = new MenuUtil(menuArr);
		output = "";
		mode = "dcm";
		operation = "";
		base = 10;
	}
	
	public static void run()
	{
		System.out.println("Mode: " + mode);
		System.out.println(output);
		
		System.out.println();
		
		menu.printMenu();
		
		System.out.println();
		
		inputFunction(menu.getStrInput("Option or value:"));
		
		System.out.println();
	}
	
	public static void inputFunction(String input)
	{
		if(isNumeric(input))
		{
			if(checkBase(input))
			{
				if(a == null)
				{
					a = modeInteger(mode, Long.parseLong(input, base));
					
					output = a.toString() + " (" + mode + ") ";
				}
				else
				{
					b = modeInteger(mode, Long.parseLong(input, base));
					
					output += b.toString() + " (" + mode + ") ";
				}
			}
			else
			{
				try
				{
					throw new Exception("Invalid base, " + input + " does not fit base " + base);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		else if(input.toLowerCase().equals("bin"))
		{
			mode = "bin";
			base = 2;
		}
		else if(input.toLowerCase().equals("oct"))
		{
			mode = "oct";
			base = 8;
		}
		else if(input.toLowerCase().equals("dcm"))
		{
			mode = "dcm";
			base = 10;
		}
		else if(input.toLowerCase().equals("hex"))
		{
			mode = "hex";
			base = 16;
		}
		else if(input.toLowerCase().equals("q"))
		{
			mode = "q";
		}
		else if(input.equals("+"))
		{
			operation = "+";
			
			output += "\t" + operation + "\t";
		}
		else if(input.equals("-"))
		{
			operation = "-";
			
			output += "\t" + operation + "\t";
		}
		else if(input.equals("*"))
		{
			operation = "*";
			
			output += "\t" + operation + "\t";
		}
		else if(input.equals("/"))
		{
			operation = "/";
			
			output += "\t" + operation + "\t";
		}
		else if(input.equals("=") && a != null && b != null)
		{
			output = Long.toString(calculate().getValue(), 16) + " (" + mode + ") ";
			
			operation = "=";
			
			a = null;
			b = null;
		}
	}
	
	public static LongInteger calculate()
	{
		if(operation.equals("+"))
		{
			return a.add(b);
		}
		else if(operation.equals("-"))
		{
			return a.subtract(b);
		}
		else if(operation.equals("*"))
		{
			return a.multiply(b);
		}
		else if(operation.equals("/"))
		{
			return a.divide(b);
		}
		
		return new LongInteger();
	}
	
	public static LongInteger modeInteger(String m, Long val)
	{
		if(m.toLowerCase().equals("bin"))
		{
			return new BinaryInteger(val);
		}
		else if(m.toLowerCase().equals("oct"))
		{
			return new OctalInteger(val);
		}
		else if(m.toLowerCase().equals("dcm"))
		{
			return new LongInteger(val);
		}
		else if(m.toLowerCase().equals("hex"))
		{
			return new HexInteger(val);
		}
		
		return new LongInteger();
	}
	
	public static boolean checkBase(String s)
	{
		char base = ':';
		
		if(s.charAt(0) == '-')
		{
			s = s.substring(1, s.length());
		}
		
		if(mode.equals("bin"))
		{
			base = '2';
		}
		else if(mode.equals("oct"))
		{
			base = '8';
		}
		else if(mode.equals("dcm"))
		{
			base = ':';
		}
		else if(mode.equals("hex"))
		{
			base = 'F';
		}
		
		for(char c : s.toCharArray())
		{
			if(!(c <= base && c >= '0') && Character.isDigit(c))
			{
				return false;
			}
			else if(!(Character.toUpperCase(c) <= 'F' && Character.toUpperCase(c) >= 'A') && !Character.isDigit(c))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isNumeric(String s)
	{
		for(char c : s.toCharArray())
		{
			if(!(Character.isDigit(c) || (Character.toUpperCase(c) <= 'F' && Character.toUpperCase(c) >= 'A') || c == '-'))
			{
				return false;
			}
		}
		
		return true;
	}
}

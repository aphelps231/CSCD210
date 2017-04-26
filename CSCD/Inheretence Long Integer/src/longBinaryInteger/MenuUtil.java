package longBinaryInteger;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUtil
{
	private ArrayList<String> menu;
	
	public MenuUtil(ArrayList<String> menu)
	{
		this.menu = menu;
	}
	
	public void printMenu()
	{
		for(int i = 0; i < this.menu.size(); i++)
		{
			System.out.println(this.menu.get(i));
		}
	}
	
	public String getStrInput(String message)
	{
		System.out.println(message);
		
		Scanner s = new Scanner(System.in);
		
		return s.nextLine();
	}
	
	public int getIntInput(String message)
	{
		System.out.println(message);
		
		Scanner s = new Scanner(System.in);
		
		return s.nextInt();
	}
}

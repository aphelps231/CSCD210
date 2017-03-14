package fileIO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO
{
	public static void main(String[] args) throws IOException
	{
		writeToFile();
		readFromFile();
	}
	
	public static void writeToFile() throws IOException
	{
		File myFile = new File("output.txt");
		
		PrintWriter fout = new PrintWriter(myFile);
		
		for(int i = 0; i < 100; i++)
		{
			fout.println("This is line " + (i + 1));
		}
		
		fout.close();
	}
	
	public static void readFromFile() throws IOException
	{
		String str;
		File myFile = new File("output.txt");
		
		Scanner fin = new Scanner(myFile);
		
		while(fin.hasNextLine())
		{
			str = fin.nextLine();
			
			System.out.println(str);
		}
		
		fin.close();
	}
}

package searchAndSort;

public class Student implements Comparable
{
	public static int prevID = 1000;
	
	private int id;
	private String name;
	private double gpa;
	
	//CONSTRUCTORS
	public Student()
	{
		this.id = prevID;
		this.name = "new student";
		this.gpa = 0.0;
		
		prevID++;
	}
	
	public Student(int id)
	{
		this.id = id;
		this.name = "new student";
		this.gpa = 0.0;
	}
	
	public Student(String name)
	{
		this.id = prevID;
		this.name = name;
		this.gpa = 0.0;
		
		prevID++;
	}
	
	public Student(double gpa)
	{
		this.id = prevID;
		this.name = "new student";
		this.gpa = gpa;
		
		prevID++;
	}
	
	public Student(int id, String name, double gpa)
	{
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	//----------
	
	//FUNCTIONS
	public void calcGPA(double newGPA, int hours)
	{
		gpa += (newGPA / hours);
	}
	//----------
	
	//GETTERS
	public int getID()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getGPA()
	{
		return this.gpa;
	}
	//----------
	
	//SETTERS
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setGPA(double gpa)
	{
		this.gpa = gpa;
	}
	//----------
	
	//IMPLEMENTATIONS
	public int compareTo(Object a)
	{
		return this.toString().compareTo(a.toString());
	}
	
	public String toString()
	{
		return this.id + " " + this.name + " " + this.gpa;
	}
	//----------
}

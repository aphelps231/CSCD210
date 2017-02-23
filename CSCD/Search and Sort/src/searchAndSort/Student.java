package searchAndSort;

public class Student implements Comparable
{
	private int id;
	private String name;
	private double gpa;
	
	public Student(int id, String name, double gpa)
	{
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	
	public void calcGPA(double newGPA, int hours)
	{
		gpa += (newGPA / hours);
	}
	
	public int compareTo(Object a)
	{
		return this.toString().compareTo(a.toString());
	}
	
	public String toString()
	{
		return this.id + " " + this.name + " " + this.gpa;
	}
}

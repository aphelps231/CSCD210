package objectsAndComparable;

public class Student
{
	private int id;
	private String name;
	private double gpa;
	
	public void calcGPA(double newGPA, int hours)
	{
		gpa += (newGPA / hours);
	}
}

package searchAndSort;

public class StudentTester
{
	public static void main(String[] args)
	{
		Student[] arr = new Student[4];
		
		arr[0] = new Student();
		arr[1] = new Student(1318);
		arr[2] = new Student("andrew");
		arr[3] = new Student(4.0);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i].toString());
		}
	}
}

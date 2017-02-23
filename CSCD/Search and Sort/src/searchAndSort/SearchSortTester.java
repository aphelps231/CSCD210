package searchAndSort;

import java.util.Arrays;

public class SearchSortTester extends SearchAndSort
{
	public static String[] arr = { "hello", "my", "name", "is", "andrew" };
	
	public static Student[] arrStudents;
	
	public static void main(String[] args)
	{
		
		
		System.out.println(Arrays.toString(arr));
		
		insertionSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void createStudents()
	{
		Student john = new Student(5183, "john", 3.95);
		Student alex = new Student(5140, "alex", 3.32);
		Student jennifer = new Student(5180, "jennifer", 3.86);
		Student steven = new Student(2907, "steven", 0.03);
		
		arrStudents = { john, alex, jennifer, steven };
	}
}

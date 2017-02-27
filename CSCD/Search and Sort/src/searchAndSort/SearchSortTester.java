package searchAndSort;

public class SearchSortTester extends SearchAndSort
{
	public static String[] arrStrings = { "hello", "my", "name", "is", "andrew" };
	
	public static Student[] arrStudents;
	
	public static void main(String[] args)
	{
		testStudentList();
		
		System.out.println("-----------");
		
		testStringsList();
		
		System.out.println("-----------");
		
		testSearch();
	}
	
	public static void testSearch()
	{
		String str = "steven";
		
		if(arrStudents == null)
		{
			return;
		}
		
		printList(arrStudents);
		System.out.println("index of \"" + str + "\": " + linearSearch(arrStudents, str));
	}
	
	public static void testStringsList()
	{
		printList(arrStrings);
		insertionSort(arrStrings);
		printList(arrStrings);
	}
	
	public static void testStudentList()
	{
		createStudents();
		
		printList(arrStudents);
		insertionSort(arrStudents);
		printList(arrStudents);
	}
	
	public static void createStudents()
	{
		Student john = new Student(5183, "john", 3.95);
		Student alex = new Student(5140, "alex", 3.32);
		Student jennifer = new Student(5180, "jennifer", 3.86);
		Student steven = new Student(2907, "steven", 3.60);
		
		arrStudents = new Student[4];
		
		arrStudents[0] = john;
		arrStudents[1] = alex; 
		arrStudents[2] = jennifer;
		arrStudents[3] = steven;
	}
	
	public static void printList(Object[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i].toString() + ", ");
		}
		
		System.out.println();
	}
}

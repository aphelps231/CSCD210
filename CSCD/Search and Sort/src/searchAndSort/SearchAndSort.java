package searchAndSort;

public class SearchAndSort
{
	public static void selectionSort(Comparable[] array)
	{
		int cur, smallest, toFill;
		Comparable tmp;
		
		for(toFill = 0; toFill < array.length - 1; toFill++)
		{
			smallest = toFill;
			
			for(cur = toFill + 1; cur < array.length; cur++)
			{
				if(array[cur].compareTo(array[smallest]) < 0)
				{
					smallest = cur;
				}
			}
			
			tmp = array[smallest];
			array[smallest] = array[toFill];
			array[toFill] = tmp;
		}
	}
	
	public static void insertionSort(Comparable[] array)
	{
		int cur;
		Comparable temp;
		
		for(int i = 1; i < array.length; i++)
		{
			temp = array[i];
			cur = i - 1;
			
			while(cur >= 0 && array[cur].compareTo(temp) > 0)
			{
				array[cur + 1] = array[cur];
				cur--;
			}
			
			array[cur + 1] = temp;
		}
	}
	
	public static void linearSearch(Comparable[] array)
	{
		
	}
}

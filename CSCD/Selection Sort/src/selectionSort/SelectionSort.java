package selectionSort;

import java.util.Arrays;

public class SelectionSort
{
	public static void main(String[] args)
	{
		int[] arr = { 2, 8, 1, 5, 6 };
		String[] arr2 = { "my", "name", "is", "Andrew" };
		
		selectionSort(arr);
		selectionSortStrings(arr2);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
	
	public static void selectionSort(int[] array)
	{
		int current, indexSmallest, posToFill;
		int temp;
		
		for(posToFill = 0; posToFill < array.length - 1; posToFill++)
		{
			indexSmallest = posToFill;
			
			for(current = posToFill + 1; current < array.length; current++)
			{
				if(array[current] < array[indexSmallest])
				{
					indexSmallest = current;
				}
			}
			
			temp = array[indexSmallest];
			array[indexSmallest] = array[posToFill];
			array[posToFill] = temp;
		}
	}
	
	public static void selectionSortStrings(String[] array)
	{
		int cur, smallest, toFill;
		String tmp;
		
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
}

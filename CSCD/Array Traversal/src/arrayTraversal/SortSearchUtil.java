package arrayTraversal;

public class SortSearchUtil
{
	public static int[] sort(int[] arr)
	{
		int current, indexSmallest, posToFill;
		int temp;
		
		for(posToFill = 0; posToFill < arr.length - 1; posToFill++)
		{
			indexSmallest = posToFill;
			
			for(current = posToFill + 1; current < arr.length; current++)
			{
				if(arr[current] < arr[indexSmallest])
				{
					indexSmallest = current;
				}
			}
			
			temp = arr[indexSmallest];
			arr[indexSmallest] = arr[posToFill];
			arr[posToFill] = temp;
		}
		
		return arr;
	}
}

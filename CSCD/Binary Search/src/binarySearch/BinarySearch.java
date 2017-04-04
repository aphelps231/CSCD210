package binarySearch;

public class BinarySearch
{
	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		System.out.println(binarySearchUtil(arr, 0));
	}
	
	public static int binarySearchUtil(int[] arr, int tar)
	{
		int high = arr.length - 1;
		int low = 0;
		int mid = 0;
		
		while(low <= high)
		{
			mid = (low + high) / 2;
			
			if(arr[mid] > tar)
			{
				high = mid - 1;
			}
			else if(arr[mid] < tar)
			{
				low = mid + 1;
			}
			else
			{
				return mid;
			}
		}
		
		return -1;
	}
}

package searching;

public class TwoD_Sorted_Array
{
	public static void main(String[] args)
	{
		int [][] arr = new int [][]
		{
			{1, 2, 4, 5,  6},  
			{2, 3, 5, 7,  8},
			{4, 6, 8, 9,  10}, 
			{5, 8, 9, 10, 11},
		};

		System.out.println(hasNumber(arr, 110));
	}

	private static boolean hasNumber (int [][] arr, int n)
	{
		if (arr == null)
		{
			throw new IllegalArgumentException("The Array can't be null");
		}
		
		int numRows = arr.length;
		
		for (int i = 0; i < numRows; i++)
		{
			int [] row = arr[i];
			boolean exists = binarySearch(row, 0, row.length - 1, n);
			
			if (exists)
			{
				return true;
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] row, int low, int high, int n)
	{
		int mid = (high + low) / 2;

		int midVal = row[mid];

		if (midVal == n)
		{
			return true;
		}
		else if (low == high)
		{
			return false;
		}
		else if (n < midVal)
		{
			return binarySearch(row, low, mid - 1, n);
		}
		else
		{
			return binarySearch(row, mid + 1, high, n);
		}
	}
}

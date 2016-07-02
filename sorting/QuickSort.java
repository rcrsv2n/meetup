package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort
{
	private static final Random RAND = new Random();

	public static void sortPivotAtEnd (int [] a, int start, int end)
	{
		if (start < end)
		{
    		int pIndex = partitionPivotAtEnd(a, start, end);
    		sortPivotAtEnd(a, start, pIndex - 1);
    		sortPivotAtEnd(a, pIndex + 1, end);
		}
	}

	private static int partitionPivotAtEnd(int[] a, int start, int end)
	{
		int pivot = a[end];
		int pIndex = start;

		for (int i = start; i < end; i++)
		{
			if (a[i] < pivot)
			{
				swap(a, i, pIndex);
				pIndex++;
			}
		}
		swap(a, pIndex, end);

		return pIndex;
	}
	
	private static void swap(int [] a, int i, int j)
	{
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args)
	{
		int [] a = {7, 2, 1, 6, 8, 5, 3, 4};

		System.out.println(Arrays.toString(a));

		sortPivotAtEnd(a, 0, 7);

		System.out.println(Arrays.toString(a));

		// random test
		int size = 100;
		int [] b = new int [size];
		for (int i = 0; i < b.length; i++)
		{
			b[i] = RAND.nextInt(400);
		}

		System.out.println(Arrays.toString(b));

		sortPivotAtEnd(b, 0, b.length - 1);

		System.out.println(Arrays.toString(b));
	}
}

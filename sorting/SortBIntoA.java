package sorting;

import java.util.Arrays;

/*
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end 
 * to hold B. Write a method to merge B into A in sorted order.
 */

public class SortBIntoA
{
	public static void main(String[] args)
	{
		// Note: Buffer is added automatically by adding b.length zeros to the end of A
		int [] a = {2, 4, 6, 8};
		int [] b = {1, 3};

		int buffSize = b.length;

		int [] cp = new int[a.length + buffSize];
		System.arraycopy(a, 0, cp, 0, a.length);

		a = cp;

		System.out.println("A = " + Arrays.toString(a));
		System.out.println("B = " + Arrays.toString(b));

		mergeBIntoA(a, b, buffSize);

		System.out.println("A = " + Arrays.toString(a));
	}

	private static void mergeBIntoA (int [] a, int [] b, int buffSize)
	{
		int end = a.length - 1;
		int aIdx = end - buffSize;
		int bIdx = b.length - 1;

		while (bIdx >= 0 && aIdx >= 0)
		{
			if (a[aIdx] > b[bIdx])
			{
				a[end--] = a[aIdx--];
			}
			else
			{
				a[end--] = b[bIdx--];
			}
		}

		while (bIdx >= 0)
		{
			a[end--] = b[bIdx--];
		}
	}
}

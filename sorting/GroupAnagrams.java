package sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each 
 * other
 */

public class GroupAnagrams
{
	public static void main(String[] args)
	{
		String [] s = {"fog", "add", "gof", "zoo", "ofg", "ooz", "gere", "dad"};
		
		System.out.println("S (before) = " + Arrays.toString(s));

		sortUsingComparator(s);

		System.out.println("S  (after) = " + Arrays.toString(s));
	}

	private static void sortUsingAnagramDetection (String [] s)
	{
		for (int i = 0; i < s.length - 2; i++)
		{
			String comp = s[i];
			int nextSpot = i + 1;

			for (int j = i + 2; j < s.length; j++)
			{
				if (isAnagram(comp, s[j]))
				{
					String tmp = s[nextSpot];
					s[nextSpot] = s[j];
					s[j] = tmp;
					
					nextSpot++;
				}
			}

			i = nextSpot - 1;
		}
	}

	private static boolean isAnagram (String a, String b)
	{
		if (a.length() != b.length())
		{
			return false;
		}

		for (char c : a.toCharArray())
		{
			int idx = b.indexOf(c);
			
			if (idx == -1)
			{
				return false;
			}
			b = b.replaceFirst(String.valueOf(c), "");
		}
		return true;
	}

	private static void sortUsingComparator (String [] s)
	{
		Arrays.sort(s, new Comparator<String> ()
		{
			@Override
			public int compare(String s1, String s2)
			{
				return sortChars(s1).compareTo(sortChars(s2));
			}

			public String sortChars(String s)
			{
				char[] content = s.toCharArray();
				Arrays.sort(content);
				return new String(content);
			}
		});
	}
}

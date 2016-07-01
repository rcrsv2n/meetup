package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets<E>
{
	private List<E> theSet;

	public SubSets (Set<E> set)
	{
		theSet = new ArrayList<E> ();
		
		theSet.addAll(set);
	}

	public List<ArrayList<E>> getAllSubSets ()
	{
		List<ArrayList<E>> subSets = new ArrayList<ArrayList<E>>();
		
		int numElems = theSet.size();
		
		int totalSubSets = 1 << numElems;
		
		for (int i = 0; i < totalSubSets; i++)
		{
			// turn i into binary
			String s = Integer.toBinaryString(i);
			while (s.length() < numElems)
			{
				s = "0" + s;
			}
			
			//System.out.println(s);
			
			ArrayList<E> thisSet = new ArrayList<>();
			for (int j = 0; j < s.length(); j++)
			{
				char c = s.charAt(j);
				if (c == '1')
				{
					thisSet.add(theSet.get(j));
				}
			}

			subSets.add(thisSet);
		}
		return subSets;
	}

	public static void main (String [] args)
	{
		Set<Integer> set = new HashSet<Integer> ();

		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		//set.add(5);

		SubSets<Integer> subSets = new SubSets<Integer>(set);

		List<ArrayList<Integer>> sets = subSets.getAllSubSets();

		int numOfSubSets = sets.size();
		System.out.println("Number of sub sets: " + numOfSubSets);
		
		for (int i = 0; i <= numOfSubSets; i++)
		{
    		for (List<Integer> list : sets)
    		{
    			if (list.size() == i)
    			{
    				System.out.println(list);
    			}
    		}
		}
	}
}

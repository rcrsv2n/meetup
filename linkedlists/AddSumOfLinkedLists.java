package linkedlists;

/*
 * You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
 * the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * EXAMPLE
 * 	Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 * 	Output: 8 -> 0 -> 8
 */

public class AddSumOfLinkedLists
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();
		list.add(3);
		list.add(1);
		list.add(5);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(5);
		list2.add(9);
		list2.add(2);

		int l1Num = convertListToInt(list);
		int l2Num = convertListToInt(list2);
		int sum = l1Num + l2Num;

		LinkedList<Character> listSum = new LinkedList<>();
		
		String s = String.valueOf(sum); 
		
		for (char c : s.toCharArray())
		{
			listSum.add(c);
		}

		System.out.println("list1: " + list);
		System.out.println("list2: " + list2);
		System.out.println("  sum: " + listSum);
	}

	private static int convertListToInt (LinkedList<Integer> list)
	{
		int n = 0;

		Node<Integer> curr = list.getHead();

		if (curr == null)
		{
			return 0;
		}

		int multiplier = 1;
		while (curr != null)
		{
			int i = curr.getData();
			n = n + (i * multiplier);
			multiplier *= 10;

			curr = curr.getNext();
		}
		return n;
	}
}

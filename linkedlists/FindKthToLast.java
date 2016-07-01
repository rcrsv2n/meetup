package linkedlists;

public class FindKthToLast
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 100; i > 0; i--)
		{
			list.add(i);
		}
		
		System.out.println(list);

		Node<Integer> n = findKthToLast(list, 8);

		System.out.println(n.getData());
	}

	private static <T> Node<T> findKthToLast (LinkedList<T> list, int k)
	{
		if (k < 1)
		{
			throw new IllegalArgumentException("k must be positive");
		}
		
		if (list == null)
		{
			throw new IllegalArgumentException("list cannot be null");
		}

		Node<T> kth = null;

		// first set a position node at the kth node in the list
		Node<T> pos = list.getHead();
		
		int i = 0;
		while (pos != null && i < k)
		{
			pos = pos.getNext();
			i++;
		}
		
		kth = list.getHead();
		
		// now move both the pos and kth pointers 
		// together until the end of the list is reached
		while (pos != null)
		{
			kth = kth.getNext();
			pos = pos.getNext();
		}

		return kth;
	}
}

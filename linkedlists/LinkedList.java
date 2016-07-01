package linkedlists;

public class LinkedList<T>
{
	Node<T> head = null;

	public LinkedList()
	{}

	public void add(T data)
	{
		Node<T> newNode = new Node<T>(data);

		if (head == null)
		{
			head = newNode;
		}
		else
		{
			Node<T> curr = head;

			while (curr.getNext() != null)
			{
				curr = curr.getNext();
			}

			curr.setNext(newNode);
		}
	}

	@Override // <-- Annotate that you are overriding the toString() method
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("head-->");

		Node<T> curr = head;

		if (curr == null)
		{
			sb.append("null");
			return sb.toString();
		}

		sb.append(curr.getData());
		curr = curr.getNext();
		while (curr != null)
		{
			sb.append("-->");
			sb.append(curr.getData());
			curr = curr.getNext();
		}
		sb.append("-->null");

		return sb.toString();
	}

	public int convertListToInt ()
	{
		int n = 0;

		Node<T> curr = head;

		if (curr == null)
		{
			return 0;
		}

		int multiplier = 1;
		while (curr != null)
		{
			if (curr.getData() instanceof Integer)
			{
				int i = (Integer) curr.getData();
				n = n + (i * multiplier);
				multiplier *= 10;
			}
			curr = curr.getNext();
		}
		return n;
	}

	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(0);
		list.add(1);

		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(5);
		list2.add(0);
		list2.add(5);
		list2.add(5);

		int l1Num = list.convertListToInt();
		int l2Num = list2.convertListToInt();
		int sum = l1Num + l2Num;

		LinkedList<Character> listSum = new LinkedList<>();
		
		String s = String.valueOf(sum); 
		
		for (char c : s.toCharArray())
		{
			listSum.add(c);
		}
		
		//System.out.println(list.convertListToInt());
		System.out.println(listSum);
	}
}

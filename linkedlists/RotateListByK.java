package linkedlists;

/*
 * Problem: Rotate linked list by K nodes
 * 
 * You are given a singly linked list, rotate the linked list counter-clockwise by k nodes. 
 * Where k is a given positive integer. i.e. if the given linked list is: 1->2->3->4->5 and k is 3, 
 * the list should be modified to: 4->5->1->2->3. Assume that k is smaller than the number 
 * of nodes in linked list. 
 * 
 */

public class RotateListByK
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 1; i <= 5; i++)
		{
			list.add(i);
		}

		System.out.println(list);
		
		rotateList(list, 3);

		System.out.println(list);
	}

	private static <T> void rotateList (LinkedList<T> list, int k)
	{
		Node<T> headCopy = list.getHead();
		
		Node<T> newTail = list.getHead();
		
		int i = 1;
		while (i < k)
		{
			newTail = newTail.getNext();
			i++;
		}
		
		Node<T> newHead = newTail.getNext();
		
		newTail.setNext(null);
		
		Node<T> curr = newHead;
		// find the end and attach to headCopy
		while (curr != null)
		{
			if (curr.getNext() == null)
			{
				curr.setNext(headCopy);
				break;
			}
			curr = curr.getNext();
		}

		// change the head
		list.setHead(newHead);
	}
}

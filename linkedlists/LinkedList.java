package linkedlists;

public class LinkedList<T>
{
	private Node<T> head = null;

	public LinkedList()
	{}

	public Node<T> getHead ()
	{
		return head;
	}

	public void setHead(Node<T> newHead)
	{
		head = newHead;
	}

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
}

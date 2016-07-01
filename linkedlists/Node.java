package linkedlists;

public class Node<T>
{
	private Node<T> next = null; 
	private T data = null;

	public Node (T data)
	{
		this.data = data;
	}

	public T getData()
	{
		return data;
	}
	
	public Node<T> getNext ()
	{
		return next;
	}

	public void setNext (Node<T> next)
	{
		this.next = next;
	}
}

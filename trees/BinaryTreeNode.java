package trees;

public class BinaryTreeNode
{
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode (int data)
	{
		this(data, null, null);
	}

	public BinaryTreeNode (int data, BinaryTreeNode left, BinaryTreeNode right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode getLeft ()
	{
		return left;
	}

	public BinaryTreeNode getRight ()
	{
		return right;
	}

	public int getData ()
	{
		return data;
	}

	public void setLeft(BinaryTreeNode newLeft)
	{
		this.left = newLeft;
	}

	public void setRight(BinaryTreeNode newRight)
	{
		this.right = newRight;
	}
}

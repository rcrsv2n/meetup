package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BinaryTree
{
	private BinaryTreeNode root = null;

	public BinaryTree ()
	{}

	public void add (int data)
	{
		if (root == null)
		{
			root = new BinaryTreeNode(data);
		}
		else
		{
			add(data, root);
		}
	}
	
	private void add (int data, BinaryTreeNode currRoot)
	{
		int currData = currRoot.getData();

		if (data < currData)
		{
			BinaryTreeNode left = currRoot.getLeft();
			if (left == null)
			{
				BinaryTreeNode newLeft = new BinaryTreeNode(data);
				currRoot.setLeft(newLeft);
			}
			else
			{
				add(data, currRoot.getLeft());
			}
		}
		else if (data > currData)
		{
			BinaryTreeNode right = currRoot.getRight();
			if (right == null)
			{
				BinaryTreeNode newRight = new BinaryTreeNode(data);
				currRoot.setRight(newRight);
			}
			else
			{
				add(data, currRoot.getRight());
			}
		}
		else
		{
			System.out.println(data + " is already in the tree.");
		}
	}

	private int size()
	{
		return size(root);
	}

	private int size(BinaryTreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		else
		{
			return 1 + size(root.getLeft()) + size(root.getRight());
		}
	}

	private int height()
	{
		return height(root);
	}

	private int height(BinaryTreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		else
		{
			int leftHeight = 1 + height(root.getLeft());
			int rightHeight = 1 + height(root.getRight());

			int max = Math.max(leftHeight, rightHeight);
			return max;
		}
	}

	public void printTree ()
	{
		int height = height();
		
		int numTabsLeft = (int) Math.pow(2, height);
		
		for (int i = 1; i <= height; i++)
		{
			char [] tabs = new char[numTabsLeft];
			Arrays.fill(tabs, '\t');

			System.out.print(tabs);
			printNodesAtHeight(height, i, 1, root);
			System.out.println();
			
			numTabsLeft = numTabsLeft / 2;
		}
	}

	private void printNodesAtHeight (int totalHeight, int depth, int currLevel, BinaryTreeNode root)
	{
		if (depth == currLevel)
		{
			System.out.print(root.getData());
			
			int numTabsInBetw = (int) Math.pow(2, totalHeight - (currLevel - 2));
			char [] tabs = new char[numTabsInBetw];
			Arrays.fill(tabs, '\t');
			System.out.print(tabs);
		}
		else if (depth > currLevel)
		{
			if (root.getLeft() != null)
			{
				printNodesAtHeight(totalHeight, depth, currLevel + 1, root.getLeft());
			}
			else
			{
				System.out.print(" ");
				
				int numTabsInBetw = (int) Math.pow(2, totalHeight - (currLevel - 1));
				char [] tabs = new char[numTabsInBetw];
				Arrays.fill(tabs, '\t');
				System.out.print(tabs);
			}
			if (root.getRight() != null)
			{
				printNodesAtHeight(totalHeight, depth, currLevel + 1, root.getRight());
			}
			else
			{
				System.out.print(" ");
				int numTabsInBetw = (int) Math.pow(2, totalHeight - (currLevel - 1));
				char [] tabs = new char[numTabsInBetw];
				Arrays.fill(tabs, '\t');
				System.out.print(tabs);
			}
		}
		else
		{
			return;
		}
	}

	public List<Integer> convertTreeToList ()
	{
		List<Integer> list = new ArrayList<Integer> ();

		convertTreeToList(list, root);

		return list;
	}

	private void convertTreeToList(List<Integer> list, BinaryTreeNode root)
	{
		BinaryTreeNode left = root.getLeft();
		if (left != null)
		{
			convertTreeToList(list, left);
		}

		list.add(root.getData());

		BinaryTreeNode right = root.getRight();
		if (right != null)
		{
			convertTreeToList(list, right);
		}
	}

	public static void main (String [] args)
	{
		// setup the tree
		BinaryTree bt = new BinaryTree();
		/*
		bt.add(32);
		bt.add(24);
		bt.add(21);
		bt.add(28);
		bt.add(14);
		bt.add(25);
		bt.add(41);
		bt.add(36);
		bt.add(47);
		bt.add(39);
		bt.add(22);
		bt.add(35);
		bt.add(50);
		bt.add(55);
		bt.add(49);
		bt.add(99);
		*/

		bt.add(20);
		bt.add(10);
		bt.add(30);
		bt.add(5);
		bt.add(15);

		bt.add(25);
		bt.add(35);
		bt.add(12);
		bt.add(17);

		bt.add(23);
		bt.add(27);

		/*
		 *								20
		 * 				10								30
		 *		5				15				25				35
		 *					12		17
		 *   
		 */
		
		/*
		for (int i = 0; i < 10; i++)
		{
			Random r = new Random();
			bt.add(r.nextInt(20));
		}
		*/

		System.out.println("Size of the tree is: "   + bt.size());
		System.out.println("Height of the tree is: " + bt.height());

		List<Integer> list = bt.convertTreeToList();
		System.out.println(list);

		bt.printTree();
		
		int [] arr = new int [] {1,7,10,15,29,35,40};
		
		BinaryTree bt2 = createBSTFromArray(arr);
		
		bt2.printTree();
	}

	public static BinaryTree createBSTFromArray(int [] arr)
	{
		BinaryTree bt = new BinaryTree();

		int midIdx = arr.length / 2;
		
		buildBST(bt, arr, midIdx, 0, arr.length);
		
		return bt;
	}

	private static void buildBST(BinaryTree bt, int[] arr, int midIdx, int low, int high)
	{
		if (midIdx == 0)
		{
			return;
		}

		System.out.println(midIdx);
		int val = arr[midIdx];
		bt.add(val);

		int midIdxLeft = (midIdx - low) / 2;
		buildBST(bt, arr, midIdxLeft, 0, midIdx);

		int midIdxRight = (high - midIdx) / 2;
		buildBST(bt, arr, midIdxRight, midIdx, high);
	}
}

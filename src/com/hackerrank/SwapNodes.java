package com.hackerrank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SwapNodes
{
	static class Node
	{
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right)
		{
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws Exception
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);
		int inputs = Integer.parseInt(in.readLine());
		Node root = new Node(1, null, null);
		List<Node> queue = new ArrayList<>();
		queue.add(root);
		while (!queue.isEmpty())
		{
			Node node = queue.remove(0);
			String line = in.readLine();
			String[] split = line.split(" ");
			int l = Integer.parseInt(split[0]);
			int r = Integer.parseInt(split[1]);

			node.left = (l == -1) ? null : new Node(l, null, null);
			node.right = (r == -1) ? null : new Node(r, null, null);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		int numOfSwaps = Integer.parseInt(in.readLine());
		for (int i = 0; i < numOfSwaps; i++)
		{
			int swapDepth = Integer.parseInt(in.readLine());
			int depth = 1;
			swapChildren(root, depth, swapDepth);
			printTree(root);
			System.out.println();
		}

	}

	private static void printTree(Node node)
	{
		if (node != null)
		{
			printTree(node.left);
			System.out.print(node.data + " ");
			printTree(node.right);
		}
	}

	private static void swapChildren(Node node, int depth, int swapDepth)
	{
		if (node != null)
		{
			if (depth % swapDepth == 0)
			{
				Node temp = node.left;
				node.left = node.right;
				node.right = temp;
			}

			depth++;
			swapChildren(node.left, depth, swapDepth);
			swapChildren(node.right, depth, swapDepth);
			depth--;
		}
	}
}

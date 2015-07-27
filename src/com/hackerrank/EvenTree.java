package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenTree
{

	static class InputUtils
	{
		static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		private static int readInt() throws IOException
		{
			String readLine = in.readLine();
			return Integer.parseInt(readLine);
		}

		private static int[] readListWithLength() throws Exception
		{
			int length = Integer.parseInt(in.readLine());
			int[] list = new int[length];
			String[] nums = in.readLine().split(" ");
			for (int i = 0; i < nums.length; i++)
			{
				list[i] = Integer.parseInt(nums[i]);
			}
			return list;
		}

		private static int[] readList() throws Exception
		{
			String[] nums = in.readLine().split(" ");
			int[] list = new int[nums.length];
			for (int i = 0; i < nums.length; i++)
			{
				list[i] = Integer.parseInt(nums[i]);
			}
			return list;
		}
	}

	static class Node
	{
		int value;
		// Node parent;
		List<Node> childrens = new ArrayList<>();;

		public Node(int value)
		{
			super();
			this.value = value;
		}
	}

	public static void main(String[] args) throws Exception
	{
		int[] inputs = InputUtils.readList();
		int edges = inputs[1];

		// construct tree
		Map<Integer, Node> nodes = new HashMap<>();
		for (int i = 0; i < edges; i++)
		{
			int[] vertices = InputUtils.readList();
			Node node = nodes.containsKey(vertices[1]) ? nodes.get(vertices[1]) : new Node(vertices[1]);
			Node child = nodes.containsKey(vertices[0]) ? nodes.get(vertices[0]) : new Node(vertices[0]);
			node.childrens.add(child);
			nodes.put(vertices[1], node);
			nodes.put(vertices[0], child);
		}
		Node root = nodes.get(1);
		getVerticesDfs(root);
		System.out.println(count);
	}

	static int count = 0;

	private static int getVerticesDfs(Node root)
	{
		int numVertices = 0;
		for (Node child : root.childrens)
		{
			int childVerticies = getVerticesDfs(child);
			if (childVerticies % 2 == 0 && !child.childrens.isEmpty())
			{
				count++;
				// System.out.println(child);
			}
			else
			{
				numVertices += childVerticies;
			}
		}
		return numVertices + 1;
	}
}

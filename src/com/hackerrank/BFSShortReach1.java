package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFSShortReach1
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

	public static void main(String[] args) throws Exception
	{
		int testCase = InputUtils.readInt();
		for (int testIndex = 0; testIndex < testCase; testIndex++)
		{
			int[] inputs = InputUtils.readList();
			int n = inputs[0];
			int numEdges = inputs[1];

			int[][] graph = new int[n][n];
			for (int j = 0; j < numEdges; j++)
			{
				int[] vertices = InputUtils.readList();
				graph[vertices[0] - 1][vertices[1] - 1] = 1;
			}

			int s = InputUtils.readInt();

			// findCostBfs(graph, s, 3, n);

			for (int i = 0; i < n; i++)
			{
				if (i == (s - 1))
					continue;

				// int costValue = cost[i] == 0 ? -1 : cost[i];
				int costValue = findCostBfs(graph, s, i, n);
				System.out.print(costValue + " ");
			}

			// System.out.println(cost);
		}
	}

	private static int findCostBfs(int[][] graph, int s, int end, int n)
	{
		int[] visited = new int[n];
		int[] cost = new int[n];
		for (int i = 0; i < n; i++)
		{
			cost[i] = 0;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(s - 1);
		while (!q.isEmpty())
		{
			int nextNode = q.remove();
			// System.out.println("nextNode = " + (nextNode + 1));
			if (visited[nextNode] == 0)
			{
				visited[nextNode] = 1;
				for (int i = 0; i < n; i++)
				{
					if (graph[nextNode][i] > 0 && visited[i] == 0)
					{
						cost[i] = cost[i] + 6;
						if (cost[i] > cost[nextNode] + 6)
							cost[i] = cost[nextNode] + 6;
						if (nextNode == end)
						{
							return cost[end];
						}
						q.add(i);
						// else
						// cost[i] = cost[i] + 6;
					}
				}
			}
		}
		return -1;
	}

	static int getUnvisitedChildNode(int i, int[][] graph, int[] visited, int n)
	{
		int j;

		for (j = 0; j < n; j++)
		{
			if (graph[i][j] > 0)
			{
				if (visited[j] == 0)
					return (j);
			}
		}

		return (-1);
	}
}

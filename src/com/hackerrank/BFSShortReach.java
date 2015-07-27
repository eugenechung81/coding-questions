package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// REF: http://en.literateprograms.org/index.php?title=Special:DownloadCode/Dijkstra%27s_algorithm_(Java)&oldid=15444
public class BFSShortReach
{
	static class InputUtils
	{
		static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// static BufferedReader in;
		// static
		// {
		// try
		// {
		// in = new BufferedReader(new FileReader("src/com/hackerrank/bfsshortreach_input05.txt"));
		// }
		// catch (FileNotFoundException e)
		// {
		// e.printStackTrace();
		// }
		// }

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

	static class Vertex implements Comparable<Vertex>
	{
		public final String name;
		public List<Edge> adjacencies = new ArrayList<>();
		public double minDistance = Double.POSITIVE_INFINITY;
		public Vertex previous;

		public Vertex(String argName)
		{
			name = argName;
		}

		public String toString()
		{
			return name;
		}

		public int compareTo(Vertex other)
		{
			return Double.compare(minDistance, other.minDistance);
		}

	}

	static class Edge
	{
		public final Vertex target;
		public final double weight;

		public Edge(Vertex argTarget, double argWeight)
		{
			target = argTarget;
			weight = argWeight;
		}
	}

	public static void computePaths(Vertex source)
	{
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty())
		{
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies)
			{
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance)
				{
					vertexQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target)
	{
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) throws Exception
	{
		int testCase = InputUtils.readInt();
		for (int testIndex = 0; testIndex < testCase; testIndex++)
		{
			int[] inputs = InputUtils.readList();
			int n = inputs[0];
			int numEdges = inputs[1];

			// create graph
			Map<String, Vertex> nodes = new HashMap<>();
			for (int j = 0; j < numEdges; j++)
			{
				int[] vertices = InputUtils.readList();
				String v1Val = String.valueOf(vertices[0]);
				String v2Val = String.valueOf(vertices[1]);
				Vertex v1 = nodes.containsKey(v1Val) ? nodes.get(v1Val) : new Vertex(v1Val);
				Vertex v2 = nodes.containsKey(v2Val) ? nodes.get(v2Val) : new Vertex(v2Val);
				v1.adjacencies.add(new Edge(v2, 6));
				v2.adjacencies.add(new Edge(v1, 6));
				nodes.put(v1Val, v1);
				nodes.put(v2Val, v2);
			}

			int s = InputUtils.readInt();

			Vertex startVertex = nodes.get(String.valueOf(s));
			if (startVertex == null)
			{
				// means not connected... print out all -1

				for (int i = 1; i <= n; i++)
				{
					if (i == (s))
						continue;

					int costValue = -1;
					System.out.print(costValue + " ");
				}
				System.out.println();
			}
			else
			{
				computePaths(startVertex);
				for (int i = 1; i <= n; i++)
				{
					if (i == (s))
						continue;

					Vertex target = nodes.get(String.valueOf(i));
					List<Vertex> path = getShortestPathTo(target);
					int costValue = path.size() <= 1 ? -1 : 6 * (path.size() - 1);
					System.out.print(costValue + " ");
				}
				System.out.println();
			}
		}
	}
}

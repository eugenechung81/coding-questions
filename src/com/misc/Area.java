package com.misc;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Area {

	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int inputs = Integer.parseInt(in.readLine());
		for (int input = 0; input < inputs; input++)
		{
			int numOfRects = Integer.parseInt(in.readLine());
			System.out.println(getArea(numOfRects));
		}
    }

	private static int getArea(int numOfRects)
	{
		// optimze later for permutations
		for (int x = 1; x < 1000000; x++)
		{
			for (int y = 1; y < x; y++)
			{
				int rectCount = getCount(x, y);
				if (rectCount >= numOfRects)
				{
					// System.out.println(x + " " + y);
					return x * y;
				}
			}
		}
		return 0;
	}

	private static int getCount(int x, int y)
	{
		// int[][] grid = new int[x][y];
		int rectCount = 0;

		for (int k = 1; k <= x; k++)
		{
			for (int i = 0; i < x; i = i + k)
			{
				for (int l = 1; l <= y; l++)
					for (int j = 0; j < y; j = j + l)
					{
						rectCount++;
					}
			}
		}
		return rectCount;
	}
}
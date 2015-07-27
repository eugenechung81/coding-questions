package com.hackerrank;

import java.util.Scanner;

public class LonelyInteger
{

	// finds one using O(n) b/c everything else will be 00000
	static int lonelyinteger(int[] a)
	{
		int result = 0;
		for (int i = 0; i < a.length; i++)
		{
			result = result ^ a[i];
		}
		return result;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int res;

		int _a_size = Integer.parseInt(in.nextLine());
		int[] _a = new int[_a_size];
		int _a_item;
		String next = in.nextLine();
		String[] next_split = next.split(" ");

		for (int _a_i = 0; _a_i < _a_size; _a_i++)
		{
			_a_item = Integer.parseInt(next_split[_a_i]);
			_a[_a_i] = _a_item;
		}

		res = lonelyinteger(_a);
		System.out.println(res);

	}
}

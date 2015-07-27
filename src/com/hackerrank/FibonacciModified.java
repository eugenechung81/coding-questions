package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FibonacciModified
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
		int[] inputs = InputUtils.readList();
		int a = inputs[0];
		int b = inputs[1];
		int n = inputs[2];
		BigInteger fib = modFib(a, b, n);
		System.out.println(fib);
	}

	private static BigInteger modFib(int a, int b, int n)
	{
		if (n == 1)
			return BigInteger.valueOf(a);
		else if (n == 2)
			return BigInteger.valueOf(b);
		else
		{
			BigInteger firstTerm = modFib(a, b, n - 1);
			return (firstTerm.multiply(firstTerm)).add(modFib(a, b, n - 2));
		}
	}
}

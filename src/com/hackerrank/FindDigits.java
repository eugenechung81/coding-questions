package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class FindDigits
{
	static class InputUtils
	{
		static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		static int readInt() throws Exception
		{
			String readLine = in.readLine();
			return Integer.parseInt(readLine);
		}
	}

	public static void main(String[] args) throws Exception
	{
		int testCases = InputUtils.readInt();
		for (int testCase = 0; testCase < testCases; testCase++)
		{
			int n = InputUtils.readInt();
			int[] values = getValues(n);
			int count = 0;
			for (int value : values)
			{
				if ((value != 0) && n % value == 0)
					count++;
			}
			System.out.println(count);
		}
	}

	private static int[] getValues(int n)
	{
		Stack<Integer> values = new Stack<>();
		while (n > 0)
		{
			values.push(n % 10);
			n = n / 10;
		}
		int[] vals = new int[values.size()];
		int i = 0;
		while (!values.isEmpty())
		{
			vals[i] = values.pop();
			i++;
		}
		return vals;
	}
}

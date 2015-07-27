package com.euler;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Euler24
{

	static class PermutationFinder
	{
		int count;
		int limit;

		public PermutationFinder(int limit)
		{
			this.count = 0;
			this.limit = limit - 1;
		}

		private String permutation(String prefix, String str)
		{
			int n = str.length();
			if (n == 0)
			{
				if (count == limit)
				{
					// System.out.println(prefix);
					return prefix;
					// count++;
				}
				else
					count++;
			}
			else
			{
				for (int i = 0; i < n; i++)
				{
					String value = permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
					if (value != null)
						return value;
				}
			}
			return null;
		}
	}


	public static void main(String[] args) throws Exception
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);
		int inputs = Integer.parseInt(in.readLine());
		for (int i = 0; i < inputs; i++)
		{
			int limit = Integer.parseInt(in.readLine());
			System.out.println(new PermutationFinder(limit).permutation("", "abcdefghijklm"));
		}
		

	}
}
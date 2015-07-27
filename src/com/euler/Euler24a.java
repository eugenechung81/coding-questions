package com.euler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Euler24a
{
	public static void main(String[] args) throws Exception
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);
		int inputs = Integer.parseInt(in.readLine());
		for (int i = 0; i < inputs; i++)
		{
			int limit = Integer.parseInt(in.readLine());
			printPermIndex(limit);
		}
	}

	private static void printPermIndex(int limit)
	{
		char[] perm = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm' };

		int count = 1;
		int numPerm = limit;

		while (count < numPerm)
		{
			int N = perm.length;
			int i = N - 1;
			while (perm[i - 1] >= perm[i])
			{
				i = i - 1;

			}
			int j = N;
			while (perm[j - 1] <= perm[i - 1])
			{
				j = j - 1;
			}
			// swap values at position i-1 and j-1
			swap(i - 1, j - 1, perm);

			i++;
			j = N;
			while (i < j)
			{
				swap(i - 1, j - 1, perm);
				i++;
				j--;
			}
			count++;
		}

		String permNum = "";
		for (int k = 0; k < perm.length; k++)
		{
			permNum = permNum + perm[k];
		}

		System.out.println(permNum);
	}

	private static void swap(int i, int j, char[] perm)
	{
		char k = perm[i];
		perm[i] = perm[j];
		perm[j] = k;
	}
}

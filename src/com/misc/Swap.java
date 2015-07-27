package com.misc;
public class Swap
{
	public static void main(String[] args)
	{
		char[] perm = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'l' };

		int count = 1;
		int numPerm = 1;
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

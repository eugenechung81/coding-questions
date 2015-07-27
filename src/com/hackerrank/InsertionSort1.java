package com.hackerrank;

import java.util.Scanner;

public class InsertionSort1
{
	public static void insertIntoSorted(int[] ar)
	{
		int v = ar[ar.length - 1];
		for (int i = ar.length - 1; i >= 0; i--)
		{
			if (i == 0)
			{
				ar[i] = v;
				printArray(ar);
				break;
			}

			int pre_i = i - 1;
			if (ar[pre_i] > v)
			{
				ar[i] = ar[pre_i];
				printArray(ar);
			}
			else
			{
				ar[i] = v;
				printArray(ar);
				break;
			}
		}
	}

	/* Tail starts here */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++)
		{
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);
	}

	private static void printArray(int[] ar)
	{
		for (int n : ar)
		{
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}

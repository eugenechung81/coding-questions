package com.facebook;
import java.util.Arrays;

public class RemoveNonZeros
{
	private static int removeNonZeros(int[] arr)
	{
		System.out.println("unsorted array: " + Arrays.toString(arr));
		int countNonZeros = 0;
		int nextNonZeroIndex = 0;
		for (int i = 0; i < arr.length; i++)
		{

			if (arr[i] == 0)
			{
				nextNonZeroIndex = (nextNonZeroIndex == 0) ? i : nextNonZeroIndex;
				for (int j = nextNonZeroIndex + 1; j < arr.length; j++)
				{
					System.out.println("j = " + j);
					if (arr[j] != 0)
					{
						swap(arr, j, i);
						nextNonZeroIndex = j;
						countNonZeros++;
						break;
					}
				}
			}
			else
				countNonZeros++;
		}
		System.out.println("sorted array: " + Arrays.toString(arr));
		System.out.println("count of non-zeros: " + countNonZeros + "\n");
		return countNonZeros;
	}

	private static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// { 1, 2, 0, 0, 5, 0, 3, 0, 1 } will return [1, 2, 5, 3, 1, 0, 0, 0, 0] with 5 as count of non zeros
    public static void main(String[] args)
    {
		removeNonZeros(new int[] { 1, 2, 0, 0, 5, 0, 3, 0, 1 });

		// more test cases
		removeNonZeros(new int[] { 12, 0, 7, 0, 8, 0, 3 });
		removeNonZeros(new int[] { 1, -5, 0, 0, 8, 0, 1 });
		removeNonZeros(new int[] { 0, 1, 0, 1, -5, 0, 4 });
		removeNonZeros(new int[] { -4, 1, 0, 0, 2, 21, 4 });
		removeNonZeros(new int[] { -4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0,
				2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4, 1, 0, 0, 2, 21, 4 });
    }
}
package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortingIntro
{
	static class InputUtils
	{
		static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		private static int readInt() throws IOException
		{
			String readLine = in.readLine();
			return Integer.parseInt(readLine);
		}

		private static int[] readList() throws Exception
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
	}

	public static void main(String[] args) throws Exception
	{
		int searchNum = InputUtils.readInt();
		int[] list = InputUtils.readList();
		for (int i = 0; i < list.length; i++)
		{
			if (list[i] == searchNum)
			{
				System.out.println(i);
				break;
			}
		}
	}
}

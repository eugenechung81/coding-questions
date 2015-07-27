package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class InputUtils
{
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static int readInt() throws Exception
	{
		String readLine = in.readLine();
		return Integer.parseInt(readLine);
	}

	static String readString() throws Exception
	{
		String readLine = in.readLine();
		return readLine;
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
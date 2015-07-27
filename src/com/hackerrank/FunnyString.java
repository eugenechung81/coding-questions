package com.hackerrank;


public class FunnyString
{
	public static void main(String[] args) throws Exception
	{
		int num = InputUtils.readInt();
		for (int i = 0; i < num; i++)
		{
			System.out.println(isFunny(InputUtils.readString()) ? "Funny" : "Not Funny");
		}

	}

	private static boolean isFunny(String value)
	{
		for (int i = 1; i < value.length(); i++)
		{
			int charValue = Math.abs(value.charAt(i - 1) - value.charAt(i));
			int reverseValue = Math.abs(value.charAt(value.length() - i) - value.charAt(value.length() - i - 1));
			if (charValue != reverseValue)
				return false;
			// System.out.println();
		}
		return true;
	}
}

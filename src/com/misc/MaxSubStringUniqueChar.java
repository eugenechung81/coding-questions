package com.misc;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxSubStringUniqueChar
{
	public String shortestPalindrome(String s)
	{
		if (s == null || s.length() <= 1)
			return s;

		String result = null;

		int len = s.length();
		int mid = len / 2;

		for (int i = mid; i >= 1; i--)
		{
			if (s.charAt(i) == s.charAt(i - 1))
			{
				if ((result = scanFromCenter(s, i - 1, i)) != null)
					return result;
			}
			else
			{
				if ((result = scanFromCenter(s, i - 1, i - 1)) != null)
					return result;
			}
		}

		return result;
	}

	private String scanFromCenter(String s, int l, int r)
	{
		int i = 1;

		// scan from center to both sides
		for (; l - i >= 0; i++)
		{
			if (s.charAt(l - i) != s.charAt(r + i))
				break;
		}

		// if not end at the beginning of s, return null
		if (l - i >= 0)
			return null;

		StringBuilder sb = new StringBuilder(s.substring(r + i));
		sb.reverse();

		return sb.append(s).toString();
	}

	public static String maxSubString2UniqueChars(String input)
	{
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}

		System.out.println(map);
		return null;
	}

	public static String maxSubString2UniqueChars2(String s)
	{
		int maxLen = 0;
		String maxSubstring = null;
		int m = 0;

		// declare a map to track the right most position of the two characters
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			// if map contains 2 characters, process
			if (map.size() == 2 && !map.containsKey(c))
			{
				if (i - m > maxLen)
				{
					maxLen = i - m;
					maxSubstring = s.substring(m, i);
				}

				// get the left most index for
				int leftMost = s.length();
				for (Entry<Character, Integer> entry : map.entrySet())
				{
					if (entry.getValue() < leftMost)
					{
						leftMost = entry.getValue();
					}
				}

				m = leftMost + 1;
				map.remove(s.charAt(leftMost));
			}

			map.put(c, i);
		}

		if (map.size() == 2 && maxLen == 0)
		{
			return s;
		}

		return maxSubstring;
	}

	public static void ReplaceFun(char[] str, int length)
	{
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++)
		{
			if (str[i] == ' ')
			{
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--)
		{
			if (str[i] == ' ')
			{
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			}
			else
			{
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		System.out.println(str);
	}

	public static void main(String[] args)
	{
		ReplaceFun(new char[] { 'a', ' ', 'b', ' ', '\0' }, 4);

		System.out.println(maxSubString2UniqueChars2("abcbbbbcccbdddadacb")); // returns "bcbbbbcccb"
	}
}

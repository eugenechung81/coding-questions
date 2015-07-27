package com.misc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pangram
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();

		boolean[] alphabets = new boolean[26];
		for (int i = 0; i < 26; i++)
		{
			alphabets[i] = false;
		}

		for (int i = 0; i < line.length(); i++)
		{
			char c = Character.toLowerCase(line.charAt(i));
			int index = c - 'a';
			if (index < 0) // ignore other char
				continue;
			alphabets[index] = true;
		}

		boolean allTrue = true;
		for (boolean b : alphabets)
		{
			allTrue &= b;
		}

		System.out.println(allTrue ? "pangram" : "not pangram");
	}
}

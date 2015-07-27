package com.euler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Euler24b
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

	private static int factor(int i)
	{
		if (i < 0)
		{
	        return 0;
	    }
	     
	    int p = 1;
		for (int j = 1; j <= i; j++)
		{
	        p *= j;
	    }
	    return p;
	}

	private static void printPermIndex(int limit)
	{
		char[] perm = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm' };

		int N = perm.length;
		String permNum = "";
		int remain = limit - 1;
		 
		List<Character> numbers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			numbers.add(perm[i]);
		}
		 
		for (int i = 1; i < N; i++) {
			int j = remain / factor(N - i);
			remain = remain % factor(N - i);
			permNum = permNum + numbers.get(j);
			numbers.remove(j);
		    if (remain == 0) {
		        break;
		    }
		}
		 
		for (int i = 0; i < numbers.size(); i++)
		{
			permNum = permNum + numbers.get(i);
		}

		System.out.println(permNum);
	}

}

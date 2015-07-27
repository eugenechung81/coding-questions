package com.curalate;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a method that takes a number, n, and returns all prime numbers less than n.
 *
 * Brute-force approach is preferred.
 * 
 */

class GetPrime
{
	public static void main(String[] args)
	{
		System.out.println(getPrimeNumbers(13));
	}

	static boolean isPrime(int num)
	{
		if (num == 1)
			return false;

		for (int i = 2; i < num; i++)
		{
			if (num % i == 0)
				return false;
		}
		return true;
	}

	static List<Integer> getPrimeNumbers(int n)
	{
		List<Integer> primes = new ArrayList<>();
		for (int i = 1; i <= n; i++)
		{
			if (isPrime(i))
				primes.add(i);
		}
		return primes;
	}
}

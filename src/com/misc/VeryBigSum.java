package com.misc;
import java.util.Scanner;

class VeryBigSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long sum = 0;
        for (int i=0;i<t;i++) {
			int num = in.nextInt();
			sum += num;
        }
		System.out.println(sum);
    }
}
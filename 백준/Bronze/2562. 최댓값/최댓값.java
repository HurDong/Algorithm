

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] num = new int[9];
		int big =0;
		int bigIdx = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			if(num[i]>big) 
			{
				big = num[i];
				bigIdx = i+1;
			}
		}
		System.out.println(big);
		System.out.println(bigIdx);
	}
}

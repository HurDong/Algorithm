

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] rem  = new int[42];
		for(int i=0;i<10;i++)
		{
			int target = sc.nextInt();
			rem[target%42]++;
		}
		int count=0;
		for(int i=0;i<42;i++)
		{
			if(rem[i]>0) count++;
		}
		System.out.println(count);
	}
}

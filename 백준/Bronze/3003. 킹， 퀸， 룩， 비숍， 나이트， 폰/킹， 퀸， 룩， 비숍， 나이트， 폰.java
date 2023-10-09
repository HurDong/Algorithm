

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] chess = new int[6];
		for(int i=0;i<chess.length;i++)
		{
			chess[i] = sc.nextInt();
		}
		System.out.print((1-chess[0]) + " " +( 1-chess[1]) + " " +( 2-chess[2]) + " " + (2-chess[3]) + " " + (2- chess[4]) + " " + (8 - chess[5]));
	}
}

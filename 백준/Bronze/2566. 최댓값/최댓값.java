

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] A = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		int large = 0;
		int largeX =0, largeY=0;
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(A[i][j] >= large) {
					large = A[i][j];
					largeX = i;
					largeY= j;
				}
			}
				
		}
		
		System.out.println(large);
		System.out.println((largeX + 1) + " " + (largeY + 1));
		
		
		
	}
}

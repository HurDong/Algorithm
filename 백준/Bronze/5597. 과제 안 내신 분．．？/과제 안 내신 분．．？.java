

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] student = new int[31];
		int attNum = 0;
		
		for(int i=0;i<28;i++)
		{
			attNum = sc.nextInt();
			for(int j=1;j<=30;j++)
			{
				if(attNum==j) student[j] = 1;  
				
			}
		}
		
		int[] ans = new int[2];
		int idx = 0;
		
		for(int i=1;i<=30;i++)
		{
			if(student[i]==0) {
				ans[idx] = i;
				idx++;
			}
		}
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
}

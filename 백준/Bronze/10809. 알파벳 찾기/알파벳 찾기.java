

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] engNum = new int[26];
		
		for (int i = 0; i < 26; i++) {
			engNum[i] = -1;			
		}
		
		char[] input = sc.next().toCharArray();
		
		for (int i = 0; i < input.length; i++) {
			if(engNum[((int)input[i]) - 97]==-1)
			{	
				engNum[((int)input[i]) - 97] = i;				
			}
		}
		
		for(int i =0;i<engNum.length;i++)
			System.out.print(engNum[i] + " ");

	}
}

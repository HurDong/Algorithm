

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] words = new char[5][15];
		
		for(int i=0;i<5;i++)
		{
			String s = sc.next();
			for(int j=0;j<s.length();j++)
			{
				words[i][j] = s.charAt(j); 
			}
			
		}
		
		
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<5;j++)
				if(words[j][i] != '\u0000') System.out.print(words[j][i]);
		}
	}
}

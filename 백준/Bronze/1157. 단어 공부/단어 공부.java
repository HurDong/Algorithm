

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		char[] target = new char[word.length()];
		
		for(int i =0;i<target.length;i++)
		{
			target[i] = word.charAt(i);
		}
		
		char[] alphabet = new char[26];
		
		for(int i =0;i<target.length;i++)
		{
			int dif = (int) target[i] - 97;
			if(dif >= 0) {
				alphabet[dif]++;
			}
			else {
				alphabet[(int) target[i] - 65]++;
			}
		}
		
		char ans= '?';
		int large = 0;
		
		for(int i=0;i<26;i++)
		{
			if(large < alphabet[i]) 
			{
				large = alphabet[i];
				ans = (char)(i+65);
			}
			else if(large == alphabet[i]) {
				ans='?';
			}
		}
		System.out.println(ans);
	}
}

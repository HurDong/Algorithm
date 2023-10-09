

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] pelin = new char[s.length()];
		for(int i =0;i<s.length();i++)
		{
			pelin[i] = s.charAt(i);
		}
		boolean check = true;
		int n = s.length() - 1;
		for(int i=0;i<s.length()/2;i++)
		{
//			System.out.println(i + "번째 " + pelin[i] + " " + (n-i) + "번째" + pelin[n-i]);
			if(pelin[i] == pelin[n-i]) {
				check = true;
			}
			else {
				check = false;
				break;				
			}
		}
		if(check == true) System.out.println("1");
		else System.out.println("0");
	}
}

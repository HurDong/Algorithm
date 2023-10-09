

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s = sc.next();
			char[] ans = s.toCharArray();
			System.out.println(ans[0] + "" + ans[ans.length-1]);
		}
	}
}

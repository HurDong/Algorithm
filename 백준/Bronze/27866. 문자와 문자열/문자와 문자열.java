

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		char[] ans = S.toCharArray();
		int i = sc.nextInt() - 1;
		System.out.println(ans[i]);
	}
}

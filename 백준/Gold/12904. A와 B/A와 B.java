import java.util.Scanner;

public class Main {
	static boolean isAnswer = false;
	static String t, rt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String rs = "";
		t = sc.next();
		rt = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			rs += s.charAt(i);
		}
		for (int i = t.length() - 1; i >= 0; i--) {
			rt += t.charAt(i);
		}
		int n = s.length();
		int m = t.length();

		int p1 = 0;
		int p2 = t.length() - 1;
		boolean c = true;

		for (int i = 0; i < m - n; i++) {
			if (c) {
				if (t.charAt(p2) == 'B')
					c = false;
				p2--;
			} else {
				if (t.charAt(p1) == 'B')
					c = true;
				p1++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (c) {
				if (s.charAt(i) != t.charAt(p1 + i)) {
					System.out.println(0);
					return;
				}
			} else {
				if (s.charAt(i) != t.charAt(p2 - i)) {
					System.out.println(0);
					return;
				}
			}
		}
		System.out.println(1);
		/*
		 * // reverse 를 하는 것보다는 앞에 B를 붙히고 boolean 변수를 false 로 만드는 작업이 더 효율적이라 판단 dfs(s,
		 * false); dfs(rs, true); System.out.println(0); }
		 * 
		 * private static void dfs(String sub, boolean rev) { if (sub.length() ==
		 * t.length()) { if (rev && sub.equals(t)) { System.out.println(1);
		 * System.exit(0); } else if (!rev && sub.equals(rt)) { System.out.println(1);
		 * System.exit(0); } return; }
		 * 
		 * dfs(sub + "A", true); }
		 */
	}
}

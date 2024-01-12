import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] dp = new int[s1.length() + 1][s2.length() + 1]; // dp[i][j] : s1의 1~i번째까지 문자열과 s2의 1~j번째까지 문자열의 lcs의 길이
		// String 이차원 배열은 시간복잡도가 O(N^3)이라고 한다. 따라서 역추적을 하면서 문자열을 출력해야한다.
//		String[][] sdp = new String[s1.length() + 1][s2.length() + 1]; // sdp[i][j] : dp[i][j]에 해당하는 lcs
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int idx1 = s1.length();
		int idx2 = s2.length();
		Stack<Character> stack = new Stack<>();
		while (idx1 > 0 && idx2 > 0) {
			if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
				stack.add(s1.charAt(idx1 - 1));
				idx1--;
				idx2--;
			} else if (dp[idx1 - 1][idx2] > dp[idx1][idx2 - 1]) {
				idx1--;
			} else {
				idx2--;
			}
		}
		System.out.println(dp[s1.length()][s2.length()]);
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
//		for (int i = 1; i <= s1.length(); i++) {
//			for (int j = 1; j <= s2.length(); j++) {
//				System.out.println(i + " " + j + " " + dp[i][j] + " " + sdp[i][j]);
//			}
//		}
	}
}

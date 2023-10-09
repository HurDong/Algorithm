import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int left = 0, right = 0;
			boolean ans = true;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					left++;
				} else {
					right++;
					if (left < right) {
						ans = false;
					} else {

					}
				}
				if(j==s.length()-1) {
					if(left!=right) {
						ans = false;
					}
				}
			}
			if (ans) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}
}

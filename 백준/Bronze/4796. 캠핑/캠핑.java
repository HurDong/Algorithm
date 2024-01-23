import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 연속하는 20일중 10일 사용 가능
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int caseIdx = 1;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()); // 연속 가능 일수
			int p = Integer.parseInt(st.nextToken()); // 범위 일수
			int v = Integer.parseInt(st.nextToken()); // 전체 일수
			if (l == 0 && p == 0 && v == 0) {
				return;
			}
			int answer = (v / p) * l + Math.min(l, (v % p));
			System.out.println("Case " + caseIdx++ + ": " + answer);
		}
	}
}

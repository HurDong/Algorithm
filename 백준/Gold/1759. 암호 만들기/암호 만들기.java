import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] alphabets, answer;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 최소 한개의 모음과 두개의 자음 오름차순
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());

		C = Integer.parseInt(st.nextToken());

		alphabets = new char[C];

		answer = new char[L];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			alphabets[i] = st.nextToken().charAt(0);
		}
		// 오름차순으로 정렬
		Arrays.sort(alphabets);

		dfs(0, 0);

		System.out.println(sb.toString());
	}

	private static void dfs(int start, int depth) {
		if (depth == L) {
			int v = 0, c = 0;
			for (int i = 0; i < L; i++) {
				if (answer[i] == 'a' || answer[i] == 'e' || answer[i] == 'i' || answer[i] == 'o' || answer[i] == 'u') {
					v++;
				} else {
					c++;
				}
			}
			if (v >= 1 && c >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(answer[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			answer[depth] = alphabets[i];
			dfs(i + 1, depth + 1);
		}
	}
}

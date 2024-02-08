import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int[][] sng;
	static int n, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		BigInteger big = BigInteger.ONE;

		BigInteger div = BigInteger.ONE;

		for (int i = 0; i < m; i++) {
			big = big.multiply(BigInteger.valueOf(n - i));
			div = div.multiply(BigInteger.valueOf(i + 1));
		}

		System.out.println(big.divide(div));

//		int T = Integer.parseInt(st.nextToken());
//
//		for (int tc = 1; tc <= T; tc++) {
//			answer = ;
//
//			n = Integer.parseInt(br.readLine());
//
//			sng = new int[n + 1][n + 1];
//
//			for (int i = 1; i <= n; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 1; j <= n; j++) {
//					sng[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//
//			// 반으로 나누어 각 그룹의 재료의 시너지의 합의 차이가 가장 작은 경우를 출력
//
//		}
	}
}

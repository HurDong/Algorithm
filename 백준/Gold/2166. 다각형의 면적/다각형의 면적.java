import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		// 메모리 이슈로 2차원 배열에서 1차원 배열 두개 생성
		// Integer 스택 오버플로우로 인한 long타입 선언
		long[] x = new long[N + 1];
		long[] y = new long[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
		}
		// 마지막 배열에 첫 좌표를 입력하여 신발끈 공식을 유도
		x[N] = x[0];
		y[N] = y[0];
		// 신발끈 공식을 이용하여 다각형의 넓이를 구해보자.
		long sumA = 0;
		for (int i = 0; i < N; i++) {
			sumA += (x[i] * y[i + 1]) - (x[i + 1] * y[i]);
		}
		sumA = Math.abs(sumA);
		System.out.printf("%.1f\n", sumA / 2.0);
	}
}

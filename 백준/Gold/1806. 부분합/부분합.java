import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		int[] sum = new int[n];
//		sum[0] = arr[0];
//		for (int i = 1; i < n; i++) {
//			sum[i] = sum[i - 1] + arr[i];
//		}
//		for (int i = 0; i < n; i++) {
//			for (int j = i; j < n; j++) {
//				if (sum[j] - sum[i] >= 15) {
//					answer = Math.min(answer, j - i);
//				}
//			}
//		}
		// 누적합으로 하였으나 시간초과 문제가 발생하여 투포인터로 교체
		int start = 0, end = 0, sum = 0;
		while (true) {
			// 문제의 조건에 맞는 투포인터 찾았으면 arr[start]만큼 빼주고 다음 start로 이동
			if (sum >= s) {
				answer = Math.min(answer, end - start);
				sum -= arr[start++];
			} else if (end == n) {
				break;
				// 조건에 맞지 않는다면 arr[end]만큼 더해주고 다음 end로 이동
			} else {
				sum += arr[end++];
			}

		}
		// 불가능하면 0
		if (answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		System.out.println(answer);
	}
}

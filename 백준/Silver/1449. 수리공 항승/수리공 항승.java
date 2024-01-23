import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] holes = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			holes[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순으로 정렬
		Arrays.sort(holes);

		int count = 0;

		// 현재 테이프의 마지막 위치
		double endPoint = 0;

		// 양 끝에 0.5씩 여유가 있어야함.
		for (int i = 0; i < n; i++) {
			// 덮을 수 없는 경우
			if (holes[i] > endPoint) {
				// 새 테이프 꺼내서
				count++;
				// 덮고 0.5 여유 확보하고 endPoint 현재 구멍 위치 + 테이프 길이
				endPoint = holes[i] + l - 0.5;
			}
		}
		System.out.println(count);
	}
}

package b21921;

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

		int x = Integer.parseInt(st.nextToken());

		int[] visitors = new int[n];

		st = new StringTokenizer(br.readLine());

		int sum = 0; // 슬라이딩을 위한 sum

		for (int i = 0; i < n; i++) {
			visitors[i] = Integer.parseInt(st.nextToken());
			if (i < x) {
				sum += visitors[i];
			}
		}
		
		// 시작 포인터
		int p1 = 0;
		// 끝 포인터
		int p2 = x - 1;
		// 정답과 같은 기간이 몇개 있는지
		int count = 0;
		// x길이만큼의 방문자수 합을 저장하는 배열
		int[] sums = new int[n - (x - 1)];
		// sums의 인덱스 저장 변수
		int idx = 0;
		// 첫번째 배열 원소를 sum으로 초기화
		sums[idx++] = sum;
		// p2가 마지막 원소를 접근할 때까지
		while (true) {
			p2++;
			if (p2 < n) {
				// 슬라이딩 실시
				sum += visitors[p2];
				sum -= visitors[p1];
			} else {
				break;
			}
			p1++;
			// sums 배열에 sum을 저장
			sums[idx++] = sum;
		}
		// sums를 오름차순으로 정렬
		Arrays.sort(sums);
		// 가장 큰 sums를 max라는 정답 변수에 저장
		int max = sums[sums.length - 1];
		// max와 같은 sums를 count하여 정답 갯수 변수에 저장
		for (int i = sums.length - 1; i >= 0; i--) {
			if (max == sums[i])
				count++;
		}
		// max가 0이면 SAD 출력
		if (max == 0) {
			System.out.println("SAD");
			System.exit(0);
		}
		// 아니라면 최대 방문자 수와 그 갯수를 출력
		else {
			System.out.println(max + "\n" + count);
		}
	}
}

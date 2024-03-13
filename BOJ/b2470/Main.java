package b2470;

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

		int[] solutions = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		// 오름차순으로 정렬
		Arrays.sort(solutions);
		// 투 포인터 시작 변수 선언
		int start = 0;
		// 투 포인터 끝 변수 선언
		int end = n - 1;
		// 합 변수
		int sum = 0;
		// 정답 변수
		int answer1 = 0;

		int answer2 = n - 1;

		int answer = Math.abs(solutions[end] + solutions[start]);
		// 절댓값이 0에 가까운 쪽으로 설정
		while (start < end) {
			sum = solutions[end] + solutions[start];
			// 합이 양수이면 end를 감소
			if (sum > 0) {
				// 그 절댓값이 정답보다 작으면 답 최신화
				if (answer > Math.abs(sum)) {
					answer = Math.abs(sum);
					answer1 = start;
					answer2 = end;
				}
				end--;
			}
			// 합이 음수이면 start를 증가
			else if (sum < 0) {
				// 그 절댓값이 정답보다 작으면 답 최신화
				if (answer > Math.abs(sum)) {
					answer = Math.abs(sum);
					answer1 = start;
					answer2 = end;
				}
				start++;
			}
			// 합이 0이면 더이상 탐색할 필요도 없으므로 답 최신화 후 루프 종료
			else {
				answer1 = start;
				answer2 = end;
				break;
			}
		}
		System.out.println(solutions[answer1] + " " + solutions[answer2]);
	}
}

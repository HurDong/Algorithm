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

		long[] nums = new long[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(nums);

		long answer = Long.MAX_VALUE;

		int[] answerIdx = new int[3];

		// i 가 가장 좌측 포인터
		for (int i = 0; i < n - 2; i++) {
			// i의 위치를 고정시키고 투포인터 알고리즘 적용
			int start = i + 1;
			int end = n - 1;
			while (start < end) {
				long sum = nums[i] + nums[start] + nums[end];
				// 현재 답보다 절댓값이 작으면 answer 최신화
				if (Math.abs(sum) < Math.abs(answer)) {
					answerIdx[0] = i;
					answerIdx[1] = start;
					answerIdx[2] = end;
					answer = sum;
				}
				// 합이 0보다 작으면 start 증가
				if (sum < 0) {
					start++;
				}
				// 합이 0보다 크면 end 감소
				else if (sum > 0) {
					end--;
				}
				// 0이면 답반환
				else {
					System.out.println(nums[answerIdx[0]] + " " + nums[answerIdx[1]] + " " + nums[answerIdx[2]]);
					return;
				}
			}
		}
		System.out.println(nums[answerIdx[0]] + " " + nums[answerIdx[1]] + " " + nums[answerIdx[2]]);
	}
}

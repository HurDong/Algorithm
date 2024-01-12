package b2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] solution = new int[N]; // 오름차순으로 정렬되어 있음

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		// 투포인터를 이용한 가장 이상적인 용액 만들기.
		int start = 0;
		int end = N - 1;
		int sum = Integer.MAX_VALUE;
		int answer1 = 0;
		int answer2 = 0;

		while (start < end) {
			int curSum = solution[start] + solution[end];
			int absSum = Math.abs(curSum);
			if (absSum < sum) {
				sum = absSum;
				answer1 = solution[start];
				answer2 = solution[end];
			}
			if (curSum > 0) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(answer1 + " " + answer2);
		// 같은 값이면 뭐를 출력하든 상관없기에 그냥 제출
	}

}

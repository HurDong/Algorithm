package b15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 연속된 k개의 초밥 먹으면 할인
		// 특정 초밥에 대한 쿠폰이 있고 연속된 초밥을 먹으면 그 초밥 무료
		// 손님이 먹을 수 있는 초밥 최대가짓수 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 접시 수
		int N = Integer.parseInt(st.nextToken());

		// 초밥 가짓 수
		int d = Integer.parseInt(st.nextToken());

		// 연속 접시 수
		int k = Integer.parseInt(st.nextToken());

		// 쿠폰 번호
		int c = Integer.parseInt(st.nextToken());

		int answer = 0;

		int[] sushi = new int[N * 2];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			sushi[N + i] = sushi[i];
		}

		// 초밥 배열(회전 초밥이므로 복사해서 붙여놓기)
		HashMap<Integer, Integer> map = new HashMap<>();

		// 초기 answer 초기화
		for (int i = 0; i < k; i++) {
			map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
		}

		answer = map.size();

		for (int i = 0; i < N; i++) {
			if (sushi[i] == c) {
				i++;
			}

		}

		System.out.println(answer);
	}
}

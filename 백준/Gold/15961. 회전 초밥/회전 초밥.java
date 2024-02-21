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

		// map에 쿠폰 번호 초밥이 있으면 쿠폰 사용하여 종류 수 늘리기 불가능
		boolean couponUsed = true;

		for (int i = 0; i < k; i++) {
			map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
			if (sushi[i] == c) {
				couponUsed = false;
			}
		}

		// 초기 answer 초기화
		if (couponUsed)
			answer = map.size() + 1;
		else
			answer = map.size();

		int start = 0;

		int end = k;

		// 슬라이스 윈도우를 이용하여 인덱스를 증가하며 종류 수 수정하되, 쿠폰 번호에 해당하는 하나의 초밥에 대한 처리 해줘야함.
		while (end < (N - 1) + k) {
			// 한 칸 앞으로 가므로 가장 맨 앞에 있는 초밥을 map에서 뺀다.
			map.put(sushi[start], map.get(sushi[start]) - 1);
			// 더 이상 map에 해당 종류의 초밥이 없다면
			if (map.get(sushi[start]) == 0) {
				// map에서 해당 초밥을 삭제하고
				map.remove(sushi[start]);
				// 해당 초밥이 쿠폰 초밥이였다면 쿠폰을 사용한다.
				if (sushi[start] == c)
					couponUsed = true;
			}
			// start 증가
			start++;
			// 한 칸 앞으로 가므로 가장 맨 뒤의 다음 초밥을 map에 추가한다.
			map.put(sushi[end], map.getOrDefault(sushi[end], 0) + 1);
			// 만약 추가하려는 초밥이 쿠폰 사용 초밥이면 쿠폰 사용을 false로
			if (sushi[end] == c) {
				couponUsed = false;
			}
			// 쿠폰을 사용 안했다면 map 크기 그대로 답을 최신화
			if (!couponUsed) {
				answer = Math.max(answer, map.size());
			}
			// 쿠폰 사용했으면 종류 하나 증가시켜고 답을 최신화
			else {
				answer = Math.max(answer, map.size() + 1);
			}
			// end 증가
			end++;
		}
		System.out.println(answer);
	}
}

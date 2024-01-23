import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 수업이 겹치면 새로운 강의실 추가해야한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		// [][0] : 시작시간 [][1] : 종료시간
		int[][] lecture = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			lecture[i][0] = Integer.parseInt(st.nextToken());
			lecture[i][1] = Integer.parseInt(st.nextToken());
		}

		// 시작 시간 오름차순 정렬(같으면 종료시간 오름차순)
		Arrays.sort(lecture, (a, b) -> {
			if (a[0] == b[0])
				return a[1] - b[1];
			else
				return a[0] - b[0];
		});

//		for (int i = 0; i < n; i++) {
//			System.out.println(lecture[i][0] + " " + lecture[i][1]);
//		}

		// 각 강의실 끝나는 시간 정렬
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		queue.add(lecture[0][1]);

		// 현재 수업 인덱스
		int idx = 1;

		// 일단 한강의실에 가능한거 다한다.
		// 시간을 계속 증가시키면서 queue 에 값을 갱신해주면서 끝난 시간은 poll
		while (idx < n) {
			int[] cur = lecture[idx];
			// 가장 이른 시간에 끝나는 강의실보다 일찍 시작하는 경우
			if (cur[0] < queue.peek()) {
				queue.add(cur[1]); // 큐에 새롭게 종료 시간을 넣어준다.
			}
			// 가장 이른 시간에 끝나는 강의실보다 늦게 시작하는 경우
			else {
				// 해당 강의실의 종료시간을 최신화한다.
				queue.poll();
				queue.add(cur[1]);
			}
			idx++;
		}
		System.out.println(queue.size());
	}
}

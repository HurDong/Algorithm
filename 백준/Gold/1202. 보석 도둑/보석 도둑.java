import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		// m 무게와 v 가격을 갖는 n개의 보석을
		// c 무게만큼 버티는 가방 k개로 훔칠 수 있을 때 최대 가격
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 보석의 가격 내림차순으로 정렬
		PriorityQueue<int[]> jq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		// 가방의 무게를 오름차순으로 정렬
		TreeMap<Integer, Integer> bq = new TreeMap<>();

		int n = Integer.parseInt(st.nextToken());

		int[][] jewels = new int[n][2]; // [0] : 무게 / [1] : 가격

		int k = Integer.parseInt(st.nextToken());

		int[] bags = new int[k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i][0] = Integer.parseInt(st.nextToken());
			jewels[i][1] = Integer.parseInt(st.nextToken());
			jq.add(jewels[i]);
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			bags[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(bags);

		for (int i = 0; i < k; i++) {
			bq.put(bags[i], bq.getOrDefault(bags[i], 0) + 1);
		}

		long sum = 0;

		// 같은 무게를 가질 때 예외처리
		while (!jq.isEmpty() && !bq.isEmpty()) {
			int[] curJ = jq.poll();
			Integer curB = bq.ceilingKey(curJ[0]); // curJ의 무게보다 크지 않은 무게를 bq에서 가져옴.
			// curB가 null이면 curJ의 무게보다 큰 가방밖에 없다는 뜻.
			if (curB != null) {
				// 무게가 같은 것이 여러개가 아닐경우 삭제
				if (bq.get(curB) == 1) {
					bq.remove(curB); // curJ[0]의 무게를 갖는 원소 삭제.
				} else {
					bq.put(curB, bq.get(curB) - 1);
				}
				sum += curJ[1];
			}
		}

		System.out.println(sum);
	}
}

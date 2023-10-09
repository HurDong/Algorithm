
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		int[] setA = new int[n];

		int[] setB = new int[m];

		int countA = 0;

		int countB = 0;

		Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();

		Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			setA[i] = Integer.parseInt(st.nextToken());
			mapA.put(setA[i], 0);
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			setB[i] = Integer.parseInt(st.nextToken());
			mapB.put(setB[i], 0);
		}

		for (int i = 0; i < n; i++) {
			if (mapB.containsKey(setA[i])) {
				countB++;
			}
		}

		for (int i = 0; i < m; i++) {
			if (mapA.containsKey(setB[i])) {
				countA++;
			}
		}

		System.out.println((n + m - countA * 2));

	}
}

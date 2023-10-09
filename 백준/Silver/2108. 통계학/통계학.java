
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] num = new int[n];

		int[] origin = new int[n];

		int[] count = new int[8001];

		double sum = 0;

		int mostFrequentlyNum = -4001;

		int large = 0;

		int temp = 0;

		for (int i = 0; i <= 8000; i++) {
			count[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
			sum = sum + num[i];
		}

		Arrays.sort(num);

		for (int i = 0; i < n; i++) {
			count[num[i] + 4000]++;
		}

		System.out.println((int) Math.round(sum / n));

		System.out.println(num[n / 2]);

		int idx = -4001;
		for (int i = 8000; i >= 0; i--) {
			if (count[i] >= large) {
				large = count[i];
				temp = mostFrequentlyNum;
				mostFrequentlyNum = i - 4000;
				idx = i;
			}
		}

		int tempIdx = -4001;

		for (int i = 8000; i >= 0; i--) {
			if (idx != i) {
				if (count[idx] == count[i]) {
					tempIdx = i;
				}
			}

		}

		if (tempIdx == -4001) {
			System.out.println(mostFrequentlyNum);
		} else {
			System.out.println(tempIdx - 4000);
		}
		
		System.out.println(num[n - 1] - num[0]);

	}
}

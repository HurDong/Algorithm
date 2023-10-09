
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int[] sortedArr = arr.clone();

		Arrays.sort(sortedArr);

		Map<Integer, Integer> map = new HashMap<>();
		int idx = 0;

		for (int i = 0; i < n; i++) {
			if (!map.containsKey(sortedArr[i])) {
				map.put(sortedArr[i], idx++);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(map.get(arr[i])).append(' ');
		}
		System.out.println(sb);
	}
}

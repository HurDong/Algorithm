import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = i;
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]); // 원래의 인덱스를 기준으로 정렬
				}
				return Integer.compare(o1[0], o2[0]); // 값으로 정렬
			}
		});

		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			answer[arr[i][1]] = i;
		}

		for (int i = 0; i < n; i++) {
			sb.append(answer[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}

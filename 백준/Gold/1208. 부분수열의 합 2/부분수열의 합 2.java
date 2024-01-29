import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static int n, s;
	public static int[] nums;
	public static ArrayList<Integer> lSum = new ArrayList<>();
	public static ArrayList<Integer> rSum = new ArrayList<>();

	public static void main(String[] args) {
		// dfs와 조합으로 풀었을 때 시간초과 발생 -> meet in the middle(n이 40이므로) 와 이분탐색 사용
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		s = sc.nextInt();

		nums = new int[n];

		long count = 0;

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		// 길이가 40의 부분수열의 개수 : 2^40이므로 반으로 나눈다.
		// 2^20 는 시간 초과가 나지 않는다.
		calcSum(0, n / 2, 0, lSum);
		calcSum(n / 2, n, 0, rSum);

		// 오름차순 정렬
		Collections.sort(rSum);

		// lSum의 값을 하나씩 꺼내서 s에서 빼주고 해당 s를 만족하는 합을 rSum에서 구한다.
		for (int sum : lSum) {
			// upperBound는 크거나 같을때의 첫 인덱스, lowerBound는 클 때의 첫 인덱스
			// uppserBound - lowerBound : 이상 - 초과 -> 같을 때의 카운트만 남음
			count += upperBound(rSum, s - sum) - lowerBound(rSum, s - sum);
		}

		// s가 0일때는 공집합의 케이스는 빼줘야함
		if (s == 0)
			count--;

		System.out.println(count);
	}

	private static int lowerBound(ArrayList<Integer> list, int target) {
		int start = 0, end = list.size();
		// 이분탐색를 실시하면서 target보다 큰 list의 첫 인덱스를 return
		while (start < end) {
			int mid = (start + end) / 2;
			if (list.get(mid) < target)
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}

	private static int upperBound(ArrayList<Integer> list, int target) {
		int start = 0, end = list.size();
		// 이분탐색를 실시하면서 target보다 크거나 같은 list의 첫 인덱스를 return
		while (start < end) {
			int mid = (start + end) / 2;
			if (list.get(mid) <= target)
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}

	private static void calcSum(int start, int end, int sum, ArrayList<Integer> list) {
		if (start == end) {
			list.add(sum);
			return;
		}
		// 해당 값을 넣거나
		calcSum(start + 1, end, sum + nums[start], list);
		// 안 넣거나
		calcSum(start + 1, end, sum, list);
	}

}

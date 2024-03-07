import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		long[] nums = new long[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(nums);

		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer += goodNum(nums, i);
		}
		System.out.println(answer);
	}

	private static int goodNum(long[] nums, int index) {
		boolean isGood = false;
		long target = nums[index];
		int start = (index == 0 ? 1 : 0); // index외의 서로 다른 두수이므로 비교 후 값 할당
		int end = (index == nums.length - 1 ? nums.length - 2 : nums.length - 1);
		long sum = nums[start] + nums[end];
		while (start < end) {
			sum = nums[start] + nums[end];
			if (sum == target) {
				isGood = true;
				break;
			}
			// 합이 더 크면 end를 줄이자
			else if (sum > target) {
				end--;
				if (index == end)
					end--;
			} else {
				start++;
				if (index == start)
					start++;
			}
		}
		return isGood ? 1 : 0;
	}
}

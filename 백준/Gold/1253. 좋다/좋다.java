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
		// nums를 오름차순으로 정렬
		Arrays.sort(nums);
		// 정답 저장 변수
		int answer = 0;
		// 모든 배열의 원소에 대하여 좋은 수인지 판별 후 answer에 더해줌.
		for (int i = 0; i < n; i++)
			answer += goodNum(nums, i);

		System.out.println(answer);
	}

	private static int goodNum(long[] nums, int index) {
		// 좋은 수가 되었는 지 판별하는 boolean 변수
		boolean isGood = false;
		// 입력받은 index에 해당하는 nums[index]
		long target = nums[index];
		// index외의 서로 다른 두수이므로 비교 후 값 할당
		int start = (index == 0 ? 1 : 0);
		// index외의 서로 다른 두수이므로 비교 후 값 할당
		int end = (index == nums.length - 1 ? nums.length - 2 : nums.length - 1);
		// 투 포인터의 합 저장 변수
		long sum = nums[start] + nums[end];
		// 투 포인터
		while (start < end) {
			sum = nums[start] + nums[end];
			// 좋은 수가 되었으면 isGood를 true로 바꿔준 후 루프 탈출
			if (sum == target) {
				isGood = true;
				break;
			}
			// 합이 더 크면 end 감소
			else if (sum > target) {
				end--;
				// index와 end가 같으면 한번 더 감소
				if (index == end)
					end--;
			}
			// 합이 더 작으면 start 증가
			else {
				start++;
				// index와 start가 같으면 한번 더 증가
				if (index == start)
					start++;
			}
		}
		// isGood에 따라 반환 값 설정
		return isGood ? 1 : 0;
	}
}

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Integer[] positiveNumbers = new Integer[n];
		Integer[] negativeNumbers = new Integer[n];
		int zeroCount = 0, oneCount = 0;
		int positiveIdx = 0, negativeIdx = 0;

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (num > 1) {
				positiveNumbers[positiveIdx++] = num;
			} else if (num < 0) {
				negativeNumbers[negativeIdx++] = num;
			} else if (num == 0) {
				zeroCount++;
			} else if (num == 1) {
				oneCount++;
			}
		}

		Arrays.sort(positiveNumbers, 0, positiveIdx, Collections.reverseOrder());
		Arrays.sort(negativeNumbers, 0, negativeIdx);

		int sum = 0;

		// 양수 처리
		for (int i = 0; i < positiveIdx; i += 2) {
			if (i + 1 < positiveIdx) {
				sum += positiveNumbers[i] * positiveNumbers[i + 1];
			} else {
				sum += positiveNumbers[i];
			}
		}

		// 음수 처리
		for (int i = 0; i < negativeIdx; i += 2) {
			if (i + 1 < negativeIdx) {
				sum += negativeNumbers[i] * negativeNumbers[i + 1];
			} else {
				// 0이 있다면 음수 하나를 상쇄시킬 수 있음
				if (zeroCount > 0) {
					zeroCount--;
				} else {
					sum += negativeNumbers[i];
				}
			}
		}
		sum += oneCount;
		System.out.println(sum);
	}
}

/*
 * Integer[] nums = new Integer[n];
 * 
 * for (int i = 0; i < n; i++) { nums[i] = sc.nextInt(); }
 * 
 * // 내림차순 정렬 Arrays.sort(nums, Collections.reverseOrder());
 * 
 * int sum = 0;
 * 
 * int idx = -2; // 0 or 음수로 전환될 때의 idx를 저장 -> -2면 다 음수
 * 
 * for (int i = 0; i < n; i++) {
 * 
 * if (nums[i] > 0) { idx = -1; // 다음 원소가 있을 경우 if (i < n - 1) { // 양수면 같이 곱한다.
 * if (nums[i + 1] > 1) { sum += nums[i] * nums[i + 1]; i++; } else if (nums[i +
 * 1] == 1) { sum += nums[i] + 1; idx = i + 1; break; } // 음수 , 0일 경우 그냥 더한다.
 * else { sum += nums[i]; idx = i; break; } } // 다음 원소가 없을 경우 그냥 더해줌 else { sum
 * += nums[i]; idx = -3; } } } // 음수 or 0에 대한 연산 실시 -> 역순으로 계산 if (idx > -2) {
 * for (int i = n - 1; i > idx; i--) { if (i > idx + 1) { sum += nums[i] *
 * nums[i - 1]; i--; } else { sum += nums[i]; } } } // 다 음수면 else if (idx == -2)
 * { for (int i = n - 1; i >= 0; i--) { if (i > 0) { sum += nums[i] * nums[i -
 * 1]; i--; } else { sum += nums[i]; } } } else {
 * 
 * }
 * 
 * System.out.println(sum);
 */

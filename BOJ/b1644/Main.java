package b1644;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//	static final int INF = 4000001;
	static boolean[] isPrime; // false : 소수 / true : 소수X
	static ArrayList<Integer> primes = new ArrayList<>(); // 소수만 저장
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		isPrime = new boolean[n + 1];
		getPrimes(n);
		// 소수를 얻었으니 투포인터를 이용해 소수들의 합으로 n을 표현해보자.
		int start = 0;
		int end = 0;
		int count = 0;
		while (end <= primes.size() - 1) {
			int sum = getSum(start, end);
			if (sum == n) {
				count++;
				end++;
			} else if (sum > n) {
				start++;
			} else if (sum < n) {
				end++;
			}
		}
		System.out.println(count);
	}

	private static int getSum(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += primes.get(i);
		}
		return sum;

	}

	private static void getPrimes(int n) {
		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i <= n; i++) {
			if (!isPrime[i]) {
				primes.add(i);
				for (int j = i * 2; j <= n; j += i) {
					isPrime[j] = true;
				}
			}
		}
	}
}

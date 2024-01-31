import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// B와 R로 칠해진 볼 구성에 대하여 한가지 색의 볼만 옮길 때
		// 같은 색이 전부 모이는 최소 이동 횟수
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char[] redLeft = new char[n];

		char[] blueLeft = new char[n];

		char[] redRight = new char[n];

		char[] blueRight = new char[n];

		String s = sc.next();

		for (int i = 0; i < n; i++) {
			redLeft[i] = s.charAt(i);
			blueLeft[i] = s.charAt(i);
			redRight[i] = s.charAt(i);
			blueRight[i] = s.charAt(i);
		}

		// 두 색깔에 대하여 왼쪽 or 오른쪽으로 가는 경우의 수
		int answer = Integer.MAX_VALUE;

		// 1. 왼쪽으로
		// 왼쪽으로 이동 시 왼쪽에 있는 것부터 왼쪽으로

		// a. Red
		int redLeftCount = 0;

		for (int i = 1; i < n; i++) {
			if (redLeft[i] == 'R') {
				for (int j = 0; j < i; j++) {
					// i의 앞쪽에서 다른 색깔이 있으면
					if (redLeft[j] == 'B') {
						char temp = redLeft[i];
						redLeft[i] = redLeft[j];
						redLeft[j] = temp;
						redLeftCount++;
						break;
					}
				}
			}
		}

		answer = Math.min(answer, redLeftCount);

		// b. Blue
		int blueLeftCount = 0;

		for (int i = 1; i < n; i++) {
			if (blueLeft[i] == 'B') {
				for (int j = 0; j < i; j++) {
					// i의 앞쪽에서 다른 색깔이 있으면
					if (redLeft[j] == 'R') {
						char temp = blueLeft[i];
						blueLeft[i] = blueLeft[j];
						blueLeft[j] = temp;
						blueLeftCount++;
						break;
					}
				}
			}
		}

		answer = Math.min(answer, blueLeftCount);

		// 2. 오른쪽으로
		// 오른쪽으로 이동 시 오른쪽에 있는 것부터 오른쪽으로

		// a. Red
		int redRightCount = 0;

		for (int i = n - 2; i >= 0; i--) {
			if (redRight[i] == 'R') {
				for (int j = n - 1; j > i; j--) {
					// i의 앞쪽에서 다른 색깔이 있으면
					if (redRight[j] == 'B') {
						char temp = redRight[i];
						redRight[i] = redRight[j];
						redRight[j] = temp;
						redRightCount++;
						break;
					}
				}
			}
		}

		answer = Math.min(answer, redRightCount);

		// b. Blue
		int blueRightCount = 0;

		for (int i = n - 2; i >= 0; i--) {
			if (blueRight[i] == 'B') {
				for (int j = n - 1; j > i; j--) {
					// i의 앞쪽에서 다른 색깔이 있으면
					if (blueRight[j] == 'R') {
						char temp = blueRight[i];
						blueRight[i] = blueRight[j];
						blueRight[j] = temp;
						blueRightCount++;
						break;
					}
				}
			}
		}

		answer = Math.min(answer, blueRightCount);

		System.out.println(answer);
	}
}

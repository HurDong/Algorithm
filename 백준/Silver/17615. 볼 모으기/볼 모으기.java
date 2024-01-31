import java.util.Scanner;

public class Main {
//	public static void main(String[] args) {
//		// B와 R로 칠해진 볼 구성에 대하여 한가지 색의 볼만 옮길 때
//		// 같은 색이 전부 모이는 최소 이동 횟수
//		Scanner sc = new Scanner(System.in);
//
//		int n = sc.nextInt();
//
//		int answer = Integer.MAX_VALUE;
//
//		String s = sc.next();
//
//		// 처음 글자를 얻는다.
//		char start = s.charAt(0);
//
//		// 마지막 글자를 얻는다.
//		char end = s.charAt(n - 1);
//
//		// 앞에서 연속된
//		for (int i = 0; i < n; i++) {
//			
//		}
//
//		System.out.println(answer);
//	}
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

		int redLeftCount = 0;
		int blueLeftCount = 0;
		int redRightCount = 0;
		int blueRightCount = 0;

		if (redLeft[0] == 'B')
			blueLeftCount++;
		else
			redLeftCount++;

		for (int i = 1; i < n; i++) {
			if (redLeft[i] == 'R') {
				if (blueLeftCount > 0) {
					redLeftCount++;
				}
			} else {
				if (redLeftCount > 0) {
					blueLeftCount++;
				}
			}
		}

		if (redLeft[0] == 'B')
			blueLeftCount--;
		else
			redLeftCount--;

		answer = Math.min(answer, Math.min(redLeftCount, blueLeftCount));

		if (redLeft[n - 1] == 'B')
			blueRightCount++;
		else
			redRightCount++;

		for (int i = n - 2; i >= 0; i--) {
			if (redRight[i] == 'R') {
				if (blueRightCount > 0) {
					redRightCount++;
				}
			} else {
				if (redRightCount > 0) {
					blueRightCount++;
				}
			}
		}
		if (redLeft[n - 1] == 'B')
			blueRightCount--;
		else
			redRightCount--;
		answer = Math.min(answer, Math.min(redRightCount, blueRightCount));
		System.out.println(answer);
	}
}

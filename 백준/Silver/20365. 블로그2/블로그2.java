import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String s = sc.next();

		char[] problems = new char[n];

		for (int i = 0; i < n; i++) {
			problems[i] = s.charAt(i);
		}

		// 먼저 하나의 색(첫번째 색)으로 모두 칠하고 연속된 다른 색깔에 대하여 작업 횟수를 증가.
		boolean isContinuous = false;
		// 작업 횟수
		int count = 1;

		for (int i = 1; i < n; i++) {
			// 미리 색칠한 전체 색깔과 다른 경우 연속된 다른 색깔에 대해 하나의 작업 실시
			if (problems[0] != problems[i]) {
				// 연속되지 않은 것이라면(색깔이 바뀐다면)
				if (!isContinuous) {
					isContinuous = true;
					count++;
				}
			}
			// isContinuous를 false로 초기화해 다른 색에 대비
			else {
				isContinuous = false;
			}
		}
		System.out.println(count);
	}
}

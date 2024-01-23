import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int n;
	static char[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		n = s.length();

		// 거꾸로해도 똑같은 팰린드롬 구현(여러 케이스면 가장 사전 앞순인 것 출력)
		arr = new char[n];

		// 정답 저장 배열
		char[] answer = new char[n / 2];

		Arrays.fill(answer, 'a');

		// 팰린드롬 만들기
		PriorityQueue<Character> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			arr[i] = s.charAt(i);
			queue.add(arr[i]);
		}
		char temp = 'a';
		int idx = 0;
		// 오름차순으로 큐에 들어가있을때 poll을 하면서 같은 문자를 삭제
		while (!queue.isEmpty()) {
			char ch = queue.poll();
			if (!queue.isEmpty()) {
				// 같은 문자가 있을 경우 삭제
				if (ch == queue.peek()) {
					answer[idx++] = ch;
					queue.poll();
				}
				// 같은 문자가 없을 경우 해당 문자를 따로 저장
				else {
					if (temp == 'a') {
						temp = ch;
					}
					// 이미 저장되어 있다면 오류문 출력 후 종료
					else {
						System.out.println("I'm Sorry Hansoo");
						return;
					}
				}
			}
			// poll하고 queue에 남은 문자가 없을 경우 해당 문자를 temp에 저장
			else {
				if (temp == 'a') {
					temp = ch;
				} else {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n / 2; i++) {
			sb.append(answer[i]);
		}
		if (temp == 'a') {

		} else {
			sb.append(temp);
		}

		for (int i = 0; i < n / 2; i++) {
			sb.append(answer[((n / 2) - 1) - i]);
		}
		System.out.println(sb.toString());
	}
}

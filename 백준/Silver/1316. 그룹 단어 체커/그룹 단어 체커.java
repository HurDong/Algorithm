

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;

		for (int i = 0; i < n; i++) {
			boolean check[] = new boolean[26]; // 이전에 사용했다면 true for문동안 false로 계속 초기화
			boolean tmp = true;
			String input = sc.next();
			for (int j = 0; j < input.length(); j++) {
				int index = input.charAt(j) - 'a';
				if (check[index] == true) {
					if (input.charAt(j) != input.charAt(j - 1)) {
						tmp = false;
						break;
					}
				} else {
					check[index] = true;
				}
			}
			if (tmp == true)
				count++;
		}

		System.out.println(count);
	}
}

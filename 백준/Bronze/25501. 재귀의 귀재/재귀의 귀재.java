import java.util.Scanner;

public class Main {
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			count = 1;
			String s = sc.next();
			char[] word = new char[s.length()];
			for (int j = 0; j < s.length(); j++) {
				word[j] = s.charAt(j);
			}
			isPalindrome(word);
			System.out.println(" " + count);
		}
	}

	private static void isPalindrome(char[] word) {

		System.out.print(recursion(word, 0, word.length - 1));
	}

	private static int recursion(char[] word, int i, int j) {
		if (i >= j) {
			return 1;
		} else if (word[i] != word[j]) {
			return 0;
		} else {
			count++;
			return recursion(word, i + 1, j - 1);
		}
	}
}



import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		char[] target = new char[word.length()];

		for (int i = 0; i < target.length; i++) {
			target[i] = word.charAt(i);
		}

		int count = 0;
		int i = 0;
		
		for (i = 0; i < target.length - 1;) {
			if (target[i] == 'c' && target[i + 1] == '=') {
				count++;
				i = i + 2;
			} else if (target[i] == 'c' && target[i + 1] == '-') {
				count++;
				i = i + 2;
			} else if (i < (target.length - 2) && target[i] == 'd' && target[i + 1] == 'z' && target[i + 2] == '=') {
				count++;
				i = i + 3;
			} else if (target[i] == 'd' && target[i + 1] == '-') {
				count++;
				i = i + 2;
			} else if (target[i] == 'l' && target[i + 1] == 'j') {
				count++;
				i = i + 2;
			} else if (target[i] == 'n' && target[i + 1] == 'j') {
				count++;
				i = i + 2;
			} else if (target[i] == 's' && target[i + 1] == '=') {
				count++;
				i = i + 2;
			} else if (target[i] == 'z' && target[i + 1] == '=') {
				count++;
				i = i + 2;
			} else {
				count++;
				i = i + 1;
			}
		}
		
		if (i != target.length) {
			count++;
		}

		System.out.println(count);
	}
}

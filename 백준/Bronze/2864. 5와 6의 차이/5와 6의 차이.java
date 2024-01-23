import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		String bigA = a, bigB = b, smallA = a, smallB = b;
		// 5를 6으로 , 6을 5로 바꿀 수 있다. 최솟값 최댓값 구하기.
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '5')
				bigA = a.replace('5', '6');
			else if (a.charAt(i) == '6')
				smallA = a.replace('6', '5');

			if (b.charAt(i) == '5')
				bigB = b.replace('5', '6');
			else if (b.charAt(i) == '6')
				smallB = b.replace('6', '5');

		}
		System.out.println((Integer.parseInt(smallA) + Integer.parseInt(smallB)) + " "
				+ (Integer.parseInt(bigA) + Integer.parseInt(bigB)));
	}
}

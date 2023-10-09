

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 65 , 48
		long n = sc.nextInt();
		int b = sc.nextInt();
		int p = 0;

		while (true) {
			if (Math.pow(b, p) <= n) {
				p++;
			} else {
				p--;
				break;
			}
		}

		char[] arr = new char[p + 1];
		int temp = 0;

		for (int i = p; i >= 0; i--) {
			if (n / Math.pow(b, i) != 0) {
				temp = (int) (n / Math.pow(b, i));
				n = (int) (n%Math.pow(b,i));
				if(temp>9)
				{
					arr[i] = (char) (temp+55);
				}
				else {
					arr[i] = (char) (temp+48);
				}
			} else {
				arr[i] = '0';
			}
			

		}
		for (int i = p; i >=0; i--) {
			System.out.print(arr[i]);
		}
	}
}
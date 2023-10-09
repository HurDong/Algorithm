
import java.util.Scanner;

public class Main {
	static int[] basket;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		basket = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			basket[i] = i;
		}

		for (int idx = 0; idx < m; idx++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			change(basket, i, j);
		}
		print(basket,n);
	}

	private static void print(int[] arr, int n) {
		for(int i=1;i<=n;i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	private static void change(int[] arr, int i, int j) {
		for (int idx = 0; idx < (j - i+1)/2; idx++) {
				int temp = arr[i+idx];
				arr[i + idx] = arr[j - idx];
				arr[j - idx] = temp;
			}
		
	}
}

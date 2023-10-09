
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long X = sc.nextLong();
		int N = sc.nextInt();
		long[] price = new long[N];
		int[] amount = new int[N];
		for(int i =0;i<N;i++)
		{
			price[i] = sc.nextLong();
			amount[i] = sc.nextInt();
		}
		long pay = 0;
		for (int i = 0; i < N; i++) {
			pay = pay + price[i]*amount[i];
		}
		if(pay==X) System.out.println("Yes");
		else System.out.println("No");
	}
}


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] basket = new int[N];
		int start =0;
		int end =0;
		int ballNum =0;
		for(int i =0;i<M;i++)
		{
			start = sc.nextInt() - 1;
			end = sc.nextInt() - 1;
			ballNum = sc.nextInt();
			for(int j=start;j<=end;j++)
			{
				basket[j] = ballNum;
			}
		}
		for (int i = 0; i < basket.length; i++) {
			System.out.print(basket[i] + " ");
		}
	}
}


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int h, t, o = 0;
		h = n / 100;
		t = (n - h*100) / 10;
		o = (n - h*100 - t*10);
		int A = 100*o + 10*t + h;
		
		n = sc.nextInt();
		h = n / 100;
		t = (n - h*100) / 10;
		o = (n - h*100 - t*10);
		int B = 100*o + 10*t + h;
		if(A>B) System.out.println(A);
		else System.out.println(B);
		
		
	}
}

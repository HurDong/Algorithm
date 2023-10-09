import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 65 , 48
		String nString = sc.next();
		
		char[] N = new char[nString.length()];
		int[] num = new int[N.length];
		
		for(int i=0;i<nString.length();i++)
		{
			N[i] = nString.charAt(i);
			if(N[i]-65>=0) {
				num[i]=N[i]-65+10;
			}
			else {
				num[i]=N[i]-48;
			}
		}
		
		int B = sc.nextInt();
		
		int ans = 0;
		
		for(int i=0;i<num.length;i++)
		{
			ans = (int) (ans + Math.pow(B, i) * num[num.length-i-1]);
		}
		
		System.out.println(ans);
	}
}

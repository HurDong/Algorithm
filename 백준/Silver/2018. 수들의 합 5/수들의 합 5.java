

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start=1,end=1,sum=1,count=1;
		while(end!=n)
		{
			if(sum>n)
			{
				sum=sum-start;
				start++;
			}
			else if(sum<n)
			{
				end++;
				sum=sum+end;
			}
			else
			{
				count++;
				end++;
				sum=sum+end;
			}
			
		}
		System.out.print(count);
	}
}

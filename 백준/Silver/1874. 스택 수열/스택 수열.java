

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i =0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		int num = 1;
		boolean result = true;
		Stack<Integer> stk = new Stack<Integer>();
		StringBuffer bf = new StringBuffer();
		for(int i =0 ;i<n;i++)
		{
			if(arr[i]>=num)
			{
				while(arr[i]>=num)
				{
					stk.push(num++);
					bf.append("+\n");
				}
				stk.pop();
				bf.append("-\n");
			}
			else // arr[i] < num
			{
				int temp = stk.pop();
				if(temp > arr[i])
				{
					System.out.println("NO");
					result = false;
					break;
				}
				else
				{
					bf.append("-\n");
				}
			}
		}
		if(result==true) System.out.println(bf.toString());
		
		
		
		
		ArrayList<Character> al = new ArrayList<Character>();
		
		
	}
}	

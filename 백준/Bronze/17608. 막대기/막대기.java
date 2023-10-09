

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stk = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n =Integer.parseInt(st.nextToken());
		
		int top = 0;
		int count = 1;
		
		for(int i=0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			top = stk.push(Integer.parseInt(st.nextToken()));
		}
		
		for(int i =0;i<n;i++)
		{
			int temp = stk.pop();
			if( top < temp)
			{
				count++;
				top = temp;
			}	
		}
		System.out.println(count);
		
		
	}
}

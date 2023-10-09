

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		long count = 0;
//		
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
		
		long[] sum = new long[n];
		sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		long[] rem = new long[m];		
		for(int i = 0; i<n; i++) {
			int remainder = (int)(sum[i]%m);
			if(remainder ==0)
			{
				count++;
			}
			rem[remainder]++;

		}
		
		for(int i =0; i<m; i++) {
			if(rem[i]>1)
			{
				count = count + (rem[i]*(rem[i]-1)/2);
			}
			
		}
		
		
		
		System.out.println(count);
		
	}
}

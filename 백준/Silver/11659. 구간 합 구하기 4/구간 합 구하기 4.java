

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		int n = 0, m = 0;
		int result = 0;
		int i,j;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		int[] sum = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int k = 1; k <= n; k++) {
			arr[k] = Integer.parseInt(st.nextToken());
		}
		
		for(int k = 1; k<=n;k++) {
			sum[k]=sum[k-1]+arr[k];
		}
		
		for (int x = 0; x < m; x++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			result = sum[j]-sum[i-1];
			System.out.println(result);
		}
		
	}
}

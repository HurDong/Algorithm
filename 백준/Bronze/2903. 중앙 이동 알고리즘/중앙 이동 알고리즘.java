

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// Sn = 2^(n-1) +1 
		// Nn = 1/4 4^n + 2^n + 1 = 4^(n-1) + 2^n +1
		int n = Integer.parseInt(st.nextToken());
		n++;
		System.out.println((int)(Math.pow(4, n-1)+Math.pow(2, n)+ 1));
	}
}
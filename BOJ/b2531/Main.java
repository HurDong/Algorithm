package b2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int d = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(st.nextToken());

		int c = Integer.parseInt(st.nextToken());

		int[] belts = new int[n];

		for (int i = 0; i < n; i++) {
			belts[i] = Integer.parseInt(br.readLine());
		}
		
		
	}
}

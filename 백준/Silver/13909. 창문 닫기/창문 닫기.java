
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		
		System.out.println((int)Math.sqrt(n));
	}

}
/*
 * 1 : 1 / 2 : 1 / 3 : 1 / 4 : 2 / 5 : 2 / 6 : 2 / 7 : 2 / 8 : 3 ~ 15 : 3 / 16:
 * 4 ~ 31 : 4 / 32 : 5 1 o o o o o o o o 2 o x o x o x o x 3 o x x x o o o o 4 o
 * x x o o o o x 5 o x x o x o o x 6 o x x o x x o x 7 o x x o x x x x 7 o x x o
 * x x x o
 */

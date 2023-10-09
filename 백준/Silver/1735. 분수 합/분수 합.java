
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());

		int x = a1 * b2 + a2 * b1;
		int y = a2 * b2;
		int div = findLCM(x, y);

		System.out.println((x / div) + " " + (y / div));

	}

	private static int findLCM(int x, int y) {
		int idx = 2;
		int result = 1;
		while (idx <= x || idx <= y) {
			if (x % idx == 0 && y % idx == 0) {
				x = x / idx;
				y = y / idx;
				result = result * idx;
			} else {
				idx++;
			}
		}
		return result;
	}
}

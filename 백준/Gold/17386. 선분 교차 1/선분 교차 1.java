import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long x1, x2, x3, x4, y1, y2, y3, y4;

		st = new StringTokenizer(br.readLine());
		x1 = Long.parseLong(st.nextToken());
		y1 = Long.parseLong(st.nextToken());
		x2 = Long.parseLong(st.nextToken());
		y2 = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		x3 = Long.parseLong(st.nextToken());
		y3 = Long.parseLong(st.nextToken());
		x4 = Long.parseLong(st.nextToken());
		y4 = Long.parseLong(st.nextToken());

		long ccw123 = ccw(x1, x2, x3, y1, y2, y3);
		long ccw124 = ccw(x1, x2, x4, y1, y2, y4);
		long ccw341 = ccw(x3, x4, x1, y3, y4, y1);
		long ccw342 = ccw(x3, x4, x2, y3, y4, y2);

		long ccw12 = ccw123 * ccw124;
		long ccw34 = ccw341 * ccw342;

		if (ccw12 > 0 || ccw34 > 0) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}

	private static long ccw(long x1, long x2, long x3, long y1, long y2, long y3) {
		long result = (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x3 * y2 + x2 * y1);
		if (result > 0)
			return 1;
		else if (result == 0)
			return 0;
		else
			return -1;
	}
}

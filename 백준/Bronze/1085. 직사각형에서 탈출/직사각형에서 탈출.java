
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int xw = w - x;
		int hy = h - y;
		int ans = 0;
		if (x > xw)
			ans = xw;
		else
			ans = x;
		if (ans > hy)
			ans = hy;
		if (ans > y)
			ans = y;
		System.out.println(ans);

	}
}
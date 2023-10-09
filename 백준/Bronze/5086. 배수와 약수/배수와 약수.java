

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int w1 = -1, w2 = -1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w1 = Integer.parseInt(st.nextToken());
			w2 = Integer.parseInt(st.nextToken());
			if (w1 == 0 && w2 == 0)
				break;
			if (w1 % w2 == 0)
				System.out.println("multiple");
			else if (w2 % w1 == 0)
				System.out.println("factor");
			else
				System.out.println("neither");
		}

	}
}
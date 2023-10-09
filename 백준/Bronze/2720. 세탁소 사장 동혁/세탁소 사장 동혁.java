

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			greedy(money);

		}
	}

	private static void greedy(int money) {
		int q = 0, d = 0, n = 0, p = 0;
		while (true) {
			if ((money / 25) > 0) {
				q = money / 25;
				money = money % 25;
			} else {
				if ((money / 10) > 0) {
					d = money / 10;
					money = money % 10;
				} else {
					if ((money / 5) > 0) {
						n = money / 5;
						money = money % 5;
					} else {
						if (money / 1 > 0) {
							p = money;
							break;
						} else {
							break;
						}
					}
					{

					}
				}
			}
		}
		System.out.println(q + " " + d + " " + n + " " + p);
	}
}
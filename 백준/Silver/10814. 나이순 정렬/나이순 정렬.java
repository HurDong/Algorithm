
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		String[][] boj = new String[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			boj[i][0] = st.nextToken();
			boj[i][1] = st.nextToken();
		}

		Arrays.sort(boj, (age1, age2) -> {
			return Integer.parseInt(age1[0]) - Integer.parseInt(age2[0]);
		});

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(boj[i][j] + " ");
			}
			System.out.println();
		}
	}
}

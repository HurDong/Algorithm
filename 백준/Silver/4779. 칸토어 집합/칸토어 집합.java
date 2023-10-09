import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] blank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null && line.length() != 0) {
			int num = Integer.parseInt(line);
			blank = new char[(int) Math.pow(3, num)];
			for (int i = 0; i < blank.length; i++) {
				blank[i] = '-';
			}
			cantoar(0, blank.length, num);
			for (int j = 0; j < blank.length; j++) {
				sb.append(blank[j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void cantoar(int start, int end, int depth) {
		if (depth == 0) {
			return;
		}

		int pivot = (end - start) / 3;

		for (int i = start + pivot; i < start + (pivot * 2); i++) {
			blank[i] = ' ';
		}

		cantoar(start, start + pivot, depth - 1);

		cantoar(start + pivot * 2, end, depth - 1);
	}

}

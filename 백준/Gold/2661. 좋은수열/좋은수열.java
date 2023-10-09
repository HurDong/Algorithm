
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		findGood("");
	}

	private static void findGood(String result) {
		if (result.length() == n) {
			System.out.println(result);
			System.exit(0);
		} else {
			for (int i = 1; i <= 3; i++) {
				if (chkArr(result + i)) {
					findGood(result + i);
				}
			}
		}

	}

	private static boolean chkArr(String s) {
		int length = s.length() / 2;
		for (int i = 1; i <= length; i++) {
			if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
				return false;
			}
		}
		return true;

	}

}

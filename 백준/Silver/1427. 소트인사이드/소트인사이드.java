
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		int[] arr = new int[s.length()];
		char[] carr = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			carr[i] = s.charAt(i);
		}

		for (int i = 0; i < s.length(); i++) {
			arr[i] = (int) carr[i] - 48;
		}

		Arrays.sort(arr);

		for (int i = 0; i < s.length(); i++) {
			sb.append(arr[s.length()-i-1]);
		}
		System.out.println(sb);
	}
}

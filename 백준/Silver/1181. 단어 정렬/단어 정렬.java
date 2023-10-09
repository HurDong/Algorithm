
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		String[] words = new String[n];

		int[] wordLen = new int[n];

		int dup = 0;

		int idx = 0;

		int count = 0;

		int countWord = 0;

		while (count < n) {
			st = new StringTokenizer(br.readLine());

			words[idx] = st.nextToken();

			if (idx > 0) {
				for (int i = 0; i < idx; i++) {
					if (words[i].equals(words[idx])) {
						idx--;
						dup++;
					}
				}
			}
			idx++;
			count++;
		}

		String[] copy = new String[n - dup];

		System.arraycopy(words, 0, copy, 0, n - dup);

		Arrays.sort(copy);

		for (int i = 0; i < n - dup; i++) {
			wordLen[i] = copy[i].length();
		}

		while (countWord <= 50) {
			for (int i = 0; i < n - dup; i++) {
				if (wordLen[i] == countWord) {
					System.out.println(copy[i]);
				}
			}
			countWord++;

		}
	}
}

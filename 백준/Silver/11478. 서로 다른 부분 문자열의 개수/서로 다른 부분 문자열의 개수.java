
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String S = st.nextToken();

		char[] part = new char[S.length()];

		for (int i = 0; i < S.length(); i++) {
			part[i] = S.charAt(i);
		}

		int idx = 0;

		int n = S.length();

		Set<String> setS = new HashSet<String>();

		for (int i = idx; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			String temp = null;
			for (int j = i; j < n; j++) {
				temp = sb.append(part[j]).toString();
				if (!setS.contains(temp)) {
					setS.add(temp);
				}
			}
		}

		System.out.println(setS.size());
	}
}

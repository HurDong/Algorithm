import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> mem = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.length() >= m) {
				if (mem.containsKey(s)) {
					mem.put(s, (mem.get(s) + 1));
				} else {
					mem.put(s, 1);
				}
			}
		}

		List<String> ans = new ArrayList<String>(mem.keySet());

		Collections.sort(ans, (s1, s2) -> {
			if (mem.get(s1) == mem.get(s2)) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return Integer.compare(s2.length(), s1.length());
			} else {
				return Integer.compare(mem.get(s2), mem.get(s1));
			}
		});
		for (String word : ans) {
			sb.append(word+"\n");
		}
		System.out.println(sb.toString());
	}
}

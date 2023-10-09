
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Set<String> chongchong = new HashSet<String>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			if (s1.equals("ChongChong")) {
				chongchong.add(s2);
			} else if (s2.equals("ChongChong")) {
				chongchong.add(s1);
			}
			if (chongchong.contains(s1)) {
				chongchong.add(s2);
			} else if (chongchong.contains(s2)) {
				chongchong.add(s1);
			}
		}
		System.out.println(chongchong.size());

	}
}

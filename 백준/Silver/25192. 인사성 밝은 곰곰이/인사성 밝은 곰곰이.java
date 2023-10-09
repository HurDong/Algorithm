
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		String[] chat = new String[n];

		Map<String, Integer> kakao = new HashMap<String, Integer>(); // Integer가 1이면 곰곰을 했고 0이면 안했다.

		int gomCount = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			chat[i] = st.nextToken();

			if (chat[i].equals("ENTER")) {
				if (!kakao.isEmpty()) {
					kakao.clear();
				}
			} else {
				if (kakao.get(chat[i]) == null) {
					kakao.put(chat[i], 0);
					gomCount++;
				}

			}
		}

		System.out.println(gomCount);

	}
}


import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		Map<String, Integer> person = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			person.put(st.nextToken(), 0);
		}

		int count = 0;

		List<String> personName = new ArrayList<String>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (person.containsKey(s)) {
				personName.add(s);
				count++;
			}
		}

		Collections.sort(personName);

		for (int i = 0; i < personName.size(); i++) {
			sb.append(personName.get(i) + "\n");
		}

		System.out.println(count + "\n" + sb.toString());
	}
}


import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[] work = new String[2];

		Map<String, String> mp = new HashMap<String, String>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			work[0] = st.nextToken();
			work[1] = st.nextToken();
			if(work[1].equals("enter")) {
					mp.put(work[0], work[1]);
			}
			else {
					mp.remove(work[0]);
			}
		}
		
		ArrayList<String> list = new ArrayList<String>();
		for(String key : mp.keySet()) {
				list.add(key);
		}
		
		Collections.sort(list,Collections.reverseOrder());
		
		for(int i =0;i<list.size();i++) {
				System.out.println(list.get(i));
		}

	}
}

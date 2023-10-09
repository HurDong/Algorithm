
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long v = Integer.parseInt(st.nextToken());
		long div = ((v - a) / (a - b));
		if ((v - a) % (a - b) != 0) {
			div++;
		}
		div++;
		System.out.println(div);

	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            int sum = 0;
            int prev = 0;
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'X') {
                    prev = 0;
                } else {
                    prev += 1;
                    sum += prev;
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb.toString());
    }
}

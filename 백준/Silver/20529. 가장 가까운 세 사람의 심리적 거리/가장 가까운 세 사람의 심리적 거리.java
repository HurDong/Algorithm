import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int calcDistance(String a, String b) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if (N > 33) {
                System.out.println(0);
                br.readLine(); // Skip the line containing MBTI types
                continue;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int minDistance = Integer.MAX_VALUE;
            String[] mbti = new String[N];
            for (int i = 0; i < N; i++) {
                mbti[i] = st.nextToken();
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        int distance = calcDistance(mbti[i], mbti[j]) + calcDistance(mbti[j], mbti[k])
                                + calcDistance(mbti[i], mbti[k]);
                        minDistance = Math.min(minDistance, distance);
                    }
                }
            }

            System.out.println(minDistance);
        }
    }
}

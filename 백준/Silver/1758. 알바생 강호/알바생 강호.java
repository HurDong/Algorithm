import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[N];

        for (int i = 0; i < N; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tips, Collections.reverseOrder());

        long totalTips = 0;
        for (int i = 0; i < N; i++) {
            int actualTip = tips[i] - i;
            if (actualTip > 0) {
                totalTips += actualTip;
            }
        }

        System.out.println(totalTips);
    }
}

package b10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x, y;
            if (n % h == 0) {
                x = n / h;
                y = h;
            } else {
                x = n / h + 1;
                y = n % h;
            }
            sb.append(String.format("%d%02d\n", y, x));
        }
        System.out.println(sb.toString());
    }
}

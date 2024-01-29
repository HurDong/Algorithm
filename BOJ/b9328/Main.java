package b9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());

            int w = Integer.parseInt(st.nextToken());

            char[][] board = new char[h][w];

            int count = 0;

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = s.charAt(j);
                }
            }

            String keys = br.readLine();

            if (!keys.equals("0")) {

            }

            sb.append(count + "\n");
        }

        System.out.println(sb.toString());
    }
}

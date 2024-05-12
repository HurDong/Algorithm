package b6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final String prefix = "Escaped in ";
    static final String suffix = "minute(s).\n";
    static final String wrong = "Trapped!\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());

            int R = Integer.parseInt(st.nextToken());

            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0)
                break;

            char[][][] buliding = new char[L][R][C];

            int startX = 0;

            int startY = 0;

            int startZ = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        buliding[i][j][k] = s.charAt(k);
                        if (buliding[i][j][k] == 'S') {
                            startX = i;
                            startY = j;
                            startZ = k;
                            buliding[i][j][k] = '.'; // 이동가능한 곳으로 변환
                        }
                    }
                }
                br.readLine();
            }
            // bfs
        }
        System.out.println(sb.toString());
    }

}

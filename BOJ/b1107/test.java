package b1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    static String channel;
    static int N, M;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        channel = br.readLine();
        N = Integer.parseInt(channel);
        M = Integer.parseInt(br.readLine());
        if (M == 0) {
            System.out.println(Math.min(channel.length(), Math.abs(N - 100)));
        } else {
            visited = new boolean[10];
            min = Math.abs(N - 100);

            for (int i = 0; i < 10; i++) {
                visited[i] = true;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int disable = Integer.parseInt(st.nextToken());
                visited[disable] = false;
            }

            if (N == 100)
                System.out.println(0);
            else {
                combination(0, 0);
                System.out.println(min);
            }
        }
    }

    private static void combination(int depth, int currentChannel) {
        if (depth > 0) {
            int diff = Integer.toString(currentChannel).length() + Math.abs(N - currentChannel);
            min = Math.min(diff, min);
        }

        if (depth >= 6) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                combination(depth + 1, currentChannel * 10 + i);
            }
        }
    }
}
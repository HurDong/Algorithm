package b8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] medal = new int[N + 1][3];
        int place = 1;
        int targetG = 0, targetS = 0, targetB = 0;
        // 공동 2등이면 다음 등수는 4
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                medal[nation][j] = Integer.parseInt(st.nextToken());
            }
        }
        // K에 대해서만 생각 -> K보다 medal[][0]이 많은 사람 계산
        // -> 같은 사람은 medal[][1] 계산 -> 같은 사람은 medal[][2] 계산
        for (int i = 1; i <= N; i++) {
            if (i != K) {
                if (medal[i][0] > medal[K][0]) {
                    place++;
                } else if (medal[i][0] == medal[K][0]) {
                    if (medal[i][1] > medal[K][1]) {
                        place++;
                    } else if (medal[i][1] == medal[K][1]) {
                        if (medal[i][2] > medal[K][2]) {
                            place++;
                        }
                    }
                }
            }
        }
        System.out.println(place);
    }
}

package b2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());

        int[] videos = new int[n];

        int start = 0;

        int end = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, videos[i]);
            end += videos[i];
        }

        int answer = end;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int blueRay = mid; // mid만큼 블루레이
            for (int i = 0; i < n; i++) {
                if (blueRay < videos[i]) {
                    count++;
                    blueRay = mid;
                }
                blueRay -= videos[i];
                if (count > m) {
                    break;
                }
            }
            // 정답 값 변경 답을 찾으면 값을 줄여서 최소 블루레이 찾기
            if (count <= m) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } /*
               * else if (count < m) {
               * end = mid - 1;
               * }
               */
            // count를 늘려야하므로 end를 down
            else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}

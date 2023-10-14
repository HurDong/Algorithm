package b1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수 T 읽기
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 두 원의 중심 사이의 거리 계산
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            // 교점 개수 계산
            if (distance == 0 && r1 == r2) {
                System.out.println(-1); // 무한대 (일치)
            } else if (distance > r1 + r2 || distance < Math.abs(r1 - r2)) {
                System.out.println(0); // 교점 없음
            } else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
                System.out.println(1); // 한 점에서 만남
            } else {
                System.out.println(2); // 두 점에서 만남
            }
        }
    }
}
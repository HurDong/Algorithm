import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken()); // 현재 게임 횟수
        long Y = Long.parseLong(st.nextToken()); // 현재 이긴 게임
        long Z = (Y * 100) / X; // 현재 승률

        if (Z >= 99) {
            System.out.println(-1); // 승률이 99% 이상이면 더 이상 승률을 올릴 수 없으므로 -1 출력
        } else {
            long left = 0;
            long right = 1_000_000_000; // 최대 게임 수
            long result = Long.MAX_VALUE;
            //
            while (left <= right) {
                long mid = (left + right) / 2; // 중간값을 이용하여 검사
                long newZ = ((Y + mid) * 100) / (X + mid);

                if (newZ > Z) {
                    result = Math.min(result, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(result);
        }
    }
}

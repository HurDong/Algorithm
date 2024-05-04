import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1~9 중복x
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] nums = new boolean[988];

        // 문제에 절대 안맞는 경우에 대하여 실시
        for (int i = 123; i <= 987; i++) {
            int h = i / 100; // 백의 자리수
            int t = (i % 100) / 10; // 십의 자리수
            int o = (i % 100) % 10; // 일의 자리수
            if (h == t || h == o || t == o || h == 0 || t == 0 || o == 0) {
                nums[i] = true;
            }
        }

        // 브루트포스하게 모든 스트라이커 볼이 아닌 경우에 대하여 해당이 절대 안되는 nums[i] 를 true 세팅
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            int strike = Integer.parseInt(st.nextToken());

            int ball = Integer.parseInt(st.nextToken());

            deleteNums(nums, num, strike, ball);
        }
        // 정답 변수
        int count = 0;
        // num[i] 가 false인 것만 정답 후보
        for (int i = 123; i <= 987; i++) {
            if (!nums[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void deleteNums(boolean[] nums, int num, int strike, int ball) {
        int h = num / 100; // 부른 수의 백의 자리수
        int t = (num % 100) / 10; // 부른 수의 십의 자리수
        int o = (num % 100) % 10; // 부른 수의 일의 자리수
        for (int i = 123; i <= 987; i++) {
            // 이미 true면 볼 것도 없이 continue
            if (nums[i]) {
                continue;
            }
            int th = i / 100; // 비교해볼 수의 백의 자리수
            int tt = (i % 100) / 10; // 비교해볼 수의 십의 자리수
            int to = (i % 100) % 10; // 비교해볼 수의 일의 자리수
            int sCount = 0; // 비교해볼 수의 strike 카운트
            int bCount = 0; // 배교해볼 수의 ball 카운트
            // 숫자야구 시작
            if (th == h) {
                sCount++;
            } else if (th == t || th == o) {
                bCount++;
            }
            if (tt == t) {
                sCount++;
            } else if (tt == h || tt == o) {
                bCount++;
            }
            if (to == o) {
                sCount++;
            } else if (to == h || to == t) {
                bCount++;
            }
            // strike 카운트와 ball 카운트가 정답 카운트와 다르면 nums[i]는 정답이 아니므로 true처리
            if (sCount != strike || bCount != ball) {
                nums[i] = true;
            }
        }
    }
}

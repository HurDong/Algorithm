import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 금액이 부족하면 현재 돈을 넣고 다시 m원 추출
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken()); // 정확히 m번의 인출로 끝내기

        int[] prices = new int[n];

        int start = Integer.MIN_VALUE; // 가장 큰 금액 날의 사용 금액

        int end = 0; // 누적 금액으로 end를 설정하여 이분탐색

        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, prices[i]);
            end += prices[i];
        }

        int answer = end;
        // 이분 탐색 시작
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1; // m가 되면 끝
            int money = mid; // 현재 가지고 있는 돈
            for (int price : prices) {
                // 현재 돈보다 오늘 지출할 돈이 클 경우
                if (money < price) {
                    // 인출하여 지출
                    count++;
                    money = mid - price; // 남은 돈 처리
                }
                // 현재 돈으로 지출 가능할 경우
                else {
                    money -= price; // 남은 돈 처리
                }
            }
            // 문제 조건에 부합하면 답 비교 후 할당
            if (count <= m) {
                answer = Math.min(answer, mid);
                end = mid - 1; // m보다 작거나 같으면 end를 줄여 count를 늘림
            } else {
                start = mid + 1; // m보다 크면 start를 늘려 count를 줄임
            }
        }
        System.out.println(answer);
    }
}

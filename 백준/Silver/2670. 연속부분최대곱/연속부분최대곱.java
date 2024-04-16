import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[] nums = new double[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextDouble();
        }
        // dp[i] : 0~i까지에서의 연속된 구간의 최댓값
        double[] dp = new double[n];
        // 초기값은 자기자신
        dp[0] = nums[0];
        // 정답 변수
        double answer = dp[0];
        // dp[i] 는 이전 dp[i-1]에서 nums[i]를 곱한 값과 곱하지않은 자기자신 중 큰 것을 가짐
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], nums[i]);
            // 정답 최신화
            answer = Math.max(dp[i], answer);
        }
        // 소수 셋째자리에서 반올림 printf
        System.out.printf("%.3f", answer);
    }
}

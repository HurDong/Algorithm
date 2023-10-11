import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[] error = new int[10];
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                error[Integer.parseInt(st.nextToken())] = 1;
            }
        }
        int ans = Math.abs(target - 100); // 숫자 안누르고 +-로 가능한 경우
        // target이 몇의자리인지 알아보자.
        // error가 0인 숫자들로 target을 만들 수 있는 가장 가까운 수를 만들자.
        // 해당 수와 target간의 차이를 구해서 target의 자릿수와 더하여 값을 도출.
        for (int i = 0; i <= 1000000; i++) { // 최대 50만이므로 100만으로 세팅.
            int channel = i;
            int count = 0;
            boolean isPossible = true;

            // 0인 경우는 count =1
            if (channel == 0) {
                isPossible = error[0] != 1;
                count = 1;
            } else {
                // 자릿수를 검사
                while (channel > 0) {
                    // 해당 1의 자리 고장 시 불가능
                    if (error[channel % 10] == 1) {
                        isPossible = false;
                        break;
                    }
                    count++;
                    channel = channel / 10;
                }
            }

            if (isPossible) {
                int press = Math.abs(i - target);
                ans = Math.min(ans, count + press);
            }
        }

        System.out.println(ans);

    }
}

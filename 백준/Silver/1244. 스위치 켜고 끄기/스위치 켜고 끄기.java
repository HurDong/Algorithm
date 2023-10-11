import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 남자는 n의 배수들 on -> off / off -> on
        // 여자는 n을 중심으로 n-1,n+1이 같은 상태면 n-2,n+2상태확인 같으면 과정 반복
        // 다른 거 나오면 그 전 구간 스위치 상태 모두 바꾼다.(홀수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] sw = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sw[i] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            // 남학생
            if (gender == 1) {
                int temp = n / num;
                for (int j = 1; j <= temp; j++) {
                    if (sw[j * num] == 1) {
                        sw[j * num] = 0;
                    } else {
                        sw[j * num] = 1;
                    }
                }
            }
            // 여학생
            else {
                int count = 1;
                if (sw[num] == 1) {
                    sw[num] = 0;
                } else {
                    sw[num] = 1;
                }
                while (true) {
                    if (num - count < 1 || num + count > n) {
                        break;
                    }
                    if (sw[num - count] == sw[num + count]) {

                        if (sw[num - count] == 1) {
                            sw[num - count] = 0;
                            sw[num + count] = 0;
                        } else {
                            sw[num - count] = 1;
                            sw[num + count] = 1;
                        }
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(sw[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        // 메모리 초과 문제로 다시 재구성
        int[] dpMin = new int[3]; // 이전과 현재만 생각
        int[] dpMax = new int[3]; // 이전과 현재만 생각

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            dpMin[i] = dpMax[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num0 = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            // 최솟값
            int tempMin0 = dpMin[0];
            int tempMin1 = dpMin[1];

            dpMin[0] = Math.min(dpMin[0], dpMin[1]) + num0;
            dpMin[1] = Math.min(Math.min(tempMin0, dpMin[1]), dpMin[2]) + num1;
            dpMin[2] = Math.min(tempMin1, dpMin[2]) + num2;

            // 최댓값
            int tempMax0 = dpMax[0];
            int tempMax1 = dpMax[1];

            dpMax[0] = Math.max(dpMax[0], dpMax[1]) + num0;
            dpMax[1] = Math.max(Math.max(tempMax0, dpMax[1]), dpMax[2]) + num1;
            dpMax[2] = Math.max(tempMax1, dpMax[2]) + num2;

        }
        int maxAns = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
        int minAns = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
        System.out.println(maxAns + " " + minAns);
        // 자바 15버전으로 하면 안된다고 하네요~
    }
}
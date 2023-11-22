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
        int[] tempMin = new int[3];
        int[] tempMax = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            dpMin[i] = dpMax[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    tempMin[j] = Math.min(dpMin[j], dpMin[j + 1]) + num;
                    tempMax[j] = Math.max(dpMax[j], dpMax[j + 1]) + num;
                } else if (j == 1) {
                    tempMin[j] = Math.min(Math.min(dpMin[j - 1], dpMin[j]), dpMin[j + 1])
                            + num;
                    tempMax[j] = Math.max(Math.max(dpMax[j - 1], dpMax[j]), dpMax[j + 1])
                            + num;
                } else {
                    tempMin[j] = Math.min(dpMin[j - 1], dpMin[j]) + num;
                    tempMax[j] = Math.max(dpMax[j - 1], dpMax[j]) + num;
                }
            }
            // 다음 행 계산을 위한 이전 행 복사
            for (int k = 0; k < 3; k++) {
                dpMin[k] = tempMin[k];
                dpMax[k] = tempMax[k];
            }
        }
        int maxAns = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
        int minAns = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
        System.out.println(maxAns + " " + minAns);
    }
}
package b14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    public static void dfs(int result, int depth) {
        if (depth == N) {
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        dfs(result + numbers[depth], depth + 1);
                        break;
                    case 1:
                        dfs(result - numbers[depth], depth + 1);
                        break;
                    case 2:
                        dfs(result * numbers[depth], depth + 1);
                        break;
                    case 3:
                        dfs(result / numbers[depth], depth + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}

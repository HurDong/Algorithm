package SubsetSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int r = Integer.parseInt(st.nextToken());

        comb = new int[r];

        combination(n, r, 0, 0);
    }

    private static void combination(int n, int r, int depth, int start) {
        if (depth == r) {
            for (int num : comb) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < n; i++) {
            comb[depth] = i + 1;
            combination(n, r, depth + 1, i + 1);
        }
    }
}

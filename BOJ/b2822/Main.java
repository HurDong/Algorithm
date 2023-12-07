package b2822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] scores = new int[8];
        Integer[] indexes = new Integer[8];
        for (int i = 0; i < 8; i++) {
            scores[i] = Integer.parseInt(br.readLine());
            indexes[i] = i + 1;
        }

        Arrays.sort(indexes, (a, b) -> scores[b - 1] - scores[a - 1]);

        int sum = 0;
        int[] selected = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += scores[indexes[i] - 1];
            selected[i] = indexes[i];
        }

        Arrays.sort(selected);

        System.out.println(sum);
        for (int i : selected) {
            System.out.print(i + " ");
        }
    }
}

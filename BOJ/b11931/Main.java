package b11931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Integer[] numbers = new Integer[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 배열을 내림차순으로 정렬
        Arrays.sort(numbers, Collections.reverseOrder());

        for (int number : numbers) {
            sb.append(number).append('\n');
        }

        System.out.println(sb);
    }
}

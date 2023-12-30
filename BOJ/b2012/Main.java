package b2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(score); // 예상 등수를 오름차순으로 정렬
        long answer = 0; // 21억 넘어가므로 long으로 선언해줘야함!
        for (int i = 0; i < N; i++) {
            answer += Math.abs((i + 1) - score[i]);
        }
        System.out.println(answer);
    }
}

package b2847;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 난이도순으로 배치했지만 쉬운 난이도가 점수를 더 많는 경우가 있음.
        // 점수 내리는 것을 최소한으로

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }
        for (int i = N - 1; i >= 1; i--) {
            while (score[i] <= score[i - 1]) {
                score[i - 1]--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

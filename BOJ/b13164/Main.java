package b13164;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 티셔츠 비용은 각조 가장큰 - 가장 작은 -> 최소 비용
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int K = sc.nextInt();

        int[] kids = new int[N]; // 원생의 키

        int[] dif = new int[N - 1]; // 양 옆 차이 저장 배열

        for (int i = 0; i < N; i++) {
            kids[i] = sc.nextInt();
            if (i > 0) {
                dif[i - 1] = kids[i] - kids[i - 1];
            }
        }

        Arrays.sort(dif); // 오름차순으로 dif배열 정렬

        int answer = 0;

        // 2 2 1 4 // 3개의 조로 나누어야함 -> 가장 큰 차이부터 K번 배제해야함
        // 1 3 5 6 10

        // 범위를 N-K만큼한 이유 -> 각 조마다 속한 원생들의 차이를 넣어야함 = 조에서 가장 큰 - 가장 작은
        for (int i = 0; i < N - K; i++) {
            answer += dif[i];
        }

        System.out.println(answer);
    }
}

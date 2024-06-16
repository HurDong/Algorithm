package b19598;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        // 회의 시작 시간 오름차순 정렬
        Arrays.sort(meetings, (a, b) -> {
            return a[0] - b[0];
        });

        // 끝 시간을 저장 / 비교는 시작 시간
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(meetings[0][1]);

        for (int i = 1; i < N; i++) {
            // 현재 회의실 끝 시간보다 같거나 크면 시작 가능
            if (pq.peek() <= meetings[i][0]) {
                pq.poll(); // 해당 회의는 끝
            }
            pq.add(meetings[i][1]); // 현재 회의 pq에 추가
        }

        System.out.println(pq.size());
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int K = sc.nextInt();

        int[] sensors = new int[N];

        for (int i = 0; i < N; i++) {
            sensors[i] = sc.nextInt();
        }

        // 좌표에 올바르게 정렬
        Arrays.sort(sensors);

        // 센서보다 집중국이 더 많으면 바로 앞에 두면 되니까 거리 합 0
        if (N <= K) {
            System.out.println(0);
            return;
        }

        // 떨어진 거리가 가장 큰 것들을 반으로 쪼개서 닿게 해야한다.
        // -> 거리차가 많이 나는 구간 바로 앞에 집중국 설치
        // -> 거리차가 적게 나는 구간은 거리차만큼 집중국 거리 소요
        int[] dist = new int[N - 1];

        // 바로 옆 센서와의 거리 계산 배열
        for (int i = 0; i < N - 1; i++) {
            dist[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(dist);

        int answer = 0;

        for (int i = 0; i < N - K; i++) {
            answer += dist[i];
        }

        System.out.println(answer);
    }
}

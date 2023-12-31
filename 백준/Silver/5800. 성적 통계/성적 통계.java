import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for (int i = 1; i <= K; i++) {
            int N = sc.nextInt(); 
            int[] scores = new int[N];

            for (int j = 0; j < N; j++) {
                scores[j] = sc.nextInt();
            }

            Arrays.sort(scores); // 성적 정렬

            int maxScore = scores[N - 1];
            int minScore = scores[0];
            int maxGap = 0;

            for (int j = 0; j < N - 1; j++) {
                int gap = scores[j + 1] - scores[j];
                maxGap = Math.max(maxGap, gap);
            }

            System.out.println("Class " + i);
            System.out.println("Max " + maxScore + ", Min " + minScore + ", Largest gap " + maxGap);
        }

        sc.close();
    }
}

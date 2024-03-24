import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }

        int X = scanner.nextInt();

        int Y = scanner.nextInt();

        Arrays.sort(scores);

        int relativeGrade = (int) Math.ceil(N * (X / 100.0)); // 상대평가 A학점 학생 수
        int absoluteGrade = 0; // 절대평가 A학점 학생 수 계산
        for (int i = 0; i < N; i++) {
            if (scores[i] >= Y) {
                absoluteGrade = N - i;
                break; // Y 점수 이상인 최초 인덱스 발견 시 반복 종료
            }
        }
        System.out.println(relativeGrade + " " + absoluteGrade); // 결과 출력
    }
}

import java.util.Scanner;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static long A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
        // 가능한 두 연산 : A*2 , A*10 + 1
        // 완전탐색을 이용해 모든 연산을 해본다?
        arrowAtoB(A, 1);
        if (answer == Integer.MAX_VALUE)
            answer = -1;
        System.out.println(answer);
    }

    private static void arrowAtoB(long result, int count) {
        if (result == B) {
            answer = Math.min(answer, count);
            return;
        } else if (result > B) {
            return;
        } else {
            arrowAtoB(result * 2, count + 1);
            arrowAtoB(result * 10 + 1, count + 1);
        }
    }
}

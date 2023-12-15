import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] result = BABASolution(K);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] BABASolution(int K) {
        int a = 1, b = 0; // A와 B의 초기 개수
        for (int i = 0; i < K; i++) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return new int[] { a, b };
    }
}

package b10830;

import java.util.Scanner;

public class Main {
    static int N;
    static long B;
    static int[][] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        B = sc.nextLong();
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt() % 1000;
            }
        }
        int[][] result = pow(A, B);
        // 행렬의 제곱 A^2 = A x A -> A행렬이 a b
        // c d 일 때 A^2에서 a = a*a + b*c
        // 7 8
        // 15 22
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int[][] pow(int[][] A, long exp) {
        // 지수가 1일 경우 행렬 A를 반환.
        if (exp == 1) {
            return A;
        }
        // 분할정복을 위한 지수를 절반으로 나눔(홀수여도 상관X)
        int[][] result = pow(A, exp / 2);
        // 나머지 지수에 대해 행렬 제곱 시행
        result = multiply(result, result);
        // 지수가 홀수였을 때는 한번 더 행렬 A를 제곱해줘야한다.
        if (exp % 2 == 1) {
            result = multiply(result, A);
        }
        return result;
    }

    private static int[][] multiply(int[][] arr1, int[][] arr2) {
        int[][] arr3 = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // c1 = a1*b1 + a2*b3
                    arr3[i][j] += arr1[i][k] * arr2[k][j]; // 행렬 공부 필요....
                    arr3[i][j] %= 1000; // 1000 나머지
                }
            }
        }
        return arr3;
    }
}

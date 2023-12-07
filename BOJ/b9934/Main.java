package b9934;

import java.util.Scanner;

public class Main {
    static int k, len;
    static int[] buildings;
    static int[][] tree;
    static StringBuilder[] sb;

    public static void main(String[] args) {
        // 중위 순회 : 왼쪽 자식 -> 루트 -> 오른쪽 자식 순서
        // 완전 이진 트리 : 무조건 나누어 떨어진다.
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();

        len = (int) Math.pow(2, k) - 1;

        buildings = new int[len];

        sb = new StringBuilder[k];

        for (int i = 0; i < k; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < len; i++) {
            buildings[i] = sc.nextInt();
        }

        inOrder(0, 0, len - 1);

        for (int i = 0; i < k; i++) {
            System.out.println(sb[i].toString());
        }

    }

    private static void inOrder(int depth, int start, int end) {
        if (depth == k) {
            return;
        }
        int mid = (start + end) / 2;
        sb[depth].append(buildings[mid] + " ");
        inOrder(depth + 1, start, mid - 1);
        inOrder(depth + 1, mid + 1, end);
    }
}
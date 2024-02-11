import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int[] output;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        output = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        permute(0);
    }

    public static void permute(int depth) {
        if (depth == N) {
            for (int val : output) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permute(depth + 1);
                visited[i] = false;
            }
        }
    }
}

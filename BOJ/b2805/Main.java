package b2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순으로 정렬된 tree 배열
        Arrays.sort(tree);
        int start = 0; // 초기 H값 설정
        int end = tree[N - 1]; // 나무의 최댓값
        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] >= mid) {
                    sum += tree[i] - mid;
                }
            }
            if (sum >= M) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}

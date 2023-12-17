import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int[] nums = new int[A];
        int[] dp = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<Integer>> dpList = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            dp[i] = 1;
            dpList.add(new ArrayList<>());
            dpList.get(i).add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    ArrayList<Integer> tmp = new ArrayList<>(dpList.get(j));
                    tmp.add(nums[i]);
                    dpList.set(i, tmp);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < A; i++) {
            if (dp[max] < dp[i]) {
                max = i;
            }
        }
        System.out.println(dp[max]);
        // max일 때의 arraylist
        for (int num : dpList.get(max)) {
            System.out.print(num + " ");
        }
    }
}

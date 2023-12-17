import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // DP로 하였으나 시간초과가 일어나서 이진탐색으로 해야함.
        int A = Integer.parseInt(st.nextToken());
        int[] nums = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < A; i++) {
            // dp 마지막 원소보다 크면 -> 증가하는 원소다
            if (nums[i] > dp.get(dp.size() - 1)) {
                dp.add(nums[i]);
            } else {
                int start = 0;
                int end = dp.size() - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (dp.get(mid) < nums[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                // nus[i]의 dp리스트에서의 인덱스를 찾았으니 해당 인덱스에 위치한 요소를 nums[i]로 변경해주자.
                dp.set(end, nums[i]);
            }
        }
        System.out.println(dp.size());
    }
}

package b12015;

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
                // mid의 값보다 작은 값을 dp에 넣어야 한다 -> 그래야 다음 들어올 값에 대해 더욱 더 관대하게 배열에 입력 가능
                // 결국에는 최대 길이를 갖을 때의 원소들을 출력하는 것이 아닌 최대 길이를 구하는 것이므롷
                // dp 안에 들어 있는 원소는 정답이 아니다.
                // ArrayList.set은 해당 인덱스에 있는 원소를 nums[i]로 바꿔준다는 것이다.
                dp.set(end, nums[i]);
            }
        }
        System.out.println(dp.size());
    }
}

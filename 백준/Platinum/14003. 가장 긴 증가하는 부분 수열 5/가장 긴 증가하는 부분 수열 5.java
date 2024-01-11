import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int[] nums = new int[A];
        // 부분수열의 인덱스를 저장하는 배열 생성해줘야함
        int[] prev = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        prev[0] = 0;
        for (int i = 1; i < A; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                prev[i] = list.size() - 1;
            } else {
                int start = 0;
                int end = list.size() - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (list.get(mid) < nums[i])
                        start = mid + 1;
                    else
                        end = mid;
                }
                // 찾았으면 end번째 list 변수를 nums[i]로 변경
                list.set(end, nums[i]);
                // 자신의 위치 저장
                prev[i] = end;
            }
        }
        sb.append(list.size() + "\n");
        Stack<Integer> stack = new Stack<>();
        int idx = list.size() - 1;
        // list를 역순으로 파싱하며 스택에 저장
        for (int i = A - 1; i >= 0; i--) {
            // list에서의 인덱스와 prev에서의 인덱스가 같으면 stack에 넣는다.
            if (prev[i] == idx) {
                idx--;
                stack.push(nums[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " "); // stack이므로 역순으로 출력 가능
        }
        System.out.println(sb.toString());
    }
}

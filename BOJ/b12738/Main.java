package b12738;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int[] nums = new int[A];
        for (int i = 0; i < A; i++) {
            nums[i] = sc.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < A; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
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
            }
        }
        System.out.println(list.size());
    }
}

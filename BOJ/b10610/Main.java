package b10610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) - '0');
        }
        if (!list.contains(0)) {
            System.out.println(-1);
        } else {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            if (sum % 3 == 0) {
                int[] nums = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    nums[i] = list.get(i);
                }
                Arrays.sort(nums);
                for (int i = nums.length - 1; i >= 0; i--) {
                    System.out.print(nums[i]);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}

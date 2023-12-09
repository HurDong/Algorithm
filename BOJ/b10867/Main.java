package b10867;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        Integer[] nums = set.toArray(new Integer[0]);

        Arrays.sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

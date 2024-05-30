package b10448;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        List<Integer> nums = new ArrayList<>();

        nums.add(1);

        nums.add(3);

        while (nums.get(nums.size() - 1) <= 1000) {
            nums.add(nums.get(nums.size() - 1) + nums.size() + 1);
        }
        List<Integer> e1 = new ArrayList<>();

        List<int[]> e2 = new ArrayList<>();

        List<int[]> e3 = new ArrayList<>();

        List<Integer> eurekas = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int n1 = nums.get(i);
            for (int j = 0; j <= i; j++) {
                int n2 = nums.get(j);
                for (int k = 0; k <= i; k++) {
                    int n3 = nums.get(k);
                    eurekas.add(n1 + n2 + n3);
                }
            }
        }

        // System.out.println(eurekas);

        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            sb.append(eurekas.contains(K) ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());
    }

}

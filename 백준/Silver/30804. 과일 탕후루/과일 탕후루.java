import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }
        int left = 0;
        int right = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(fruits[0],1);
        while (right < n) {
            int next;
            if (map.size() <= 2) {
                answer = Math.max(answer, right - left + 1);
                right++;
                if (right == n) break;
                next = fruits[right];
                map.put(next,map.getOrDefault(next,0)+1);
            } else {
                next = fruits[left];
                left++;
                if (map.get(next) == 1) {
                    map.remove(next);
                } else {
                    map.put(next, map.get(next) - 1);
                }
            }
        }

        System.out.println(answer);
    }
}

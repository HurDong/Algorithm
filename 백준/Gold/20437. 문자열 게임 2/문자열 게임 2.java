import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            // step 1 : HashMap에 각 문자의 ArrrayList로 인덱스를 저장한다.
            String w = sc.next();
            int k = sc.nextInt();
            int n = w.length();
            HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c = w.charAt(i);
                if (map.containsKey(c)) {
                    map.get(c).add(i);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(c, list);
                }
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            // step 2 : 모든 HashMap의 원소에 대해 가장 짧은 문자열과 가장 긴 문자열을 나타내도록 한다.
            for (ArrayList<Integer> list : map.values()) {
                if (list.size() < k) {
                    continue;
                }
                for (int i = 0; i <= list.size() - k; i++) {
                    int start = list.get(i);
                    int end = list.get(i + k - 1);
                    int len = end - start + 1;
                    max = Math.max(max, len);
                    min = Math.min(min, len);
                }
            }
            if (max == Integer.MIN_VALUE) {
                sb.append(-1 + "\n");
            } else {
                sb.append(min + " " + max + "\n");
            }
        }
        // step 3 : 출력
        System.out.print(sb.toString());
    }
}

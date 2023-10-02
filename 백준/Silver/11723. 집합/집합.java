
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("add")) {
                int num = sc.nextInt();
                if (!set.contains(num)) {
                    set.add(num);
                }
            } else if (cmd.equals("remove")) {
                int num = sc.nextInt();
                if (set.contains(num)) {
                    set.remove(num);
                }
            } else if (cmd.equals("check")) {
                int num = sc.nextInt();
                if (set.contains(num)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (cmd.equals("toggle")) {
                int num = sc.nextInt();
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (cmd.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else {
                set.clear();
            }
        }
        System.out.println(sb.toString());
    }
}

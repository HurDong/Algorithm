package b17219;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String, String> site = new HashMap<>();
        String[] target = new String[m];
        for (int i = 0; i < n; i++) {
            site.put(sc.next(), sc.next());
        }
        for (int i = 0; i < m; i++) {
            target[i] = sc.next();
            System.out.println(site.get(target[i]));
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String num = sc.next();
            String ans = "yes\n";
            if (num.equals("0")) {
                break;
            } else {
                for (int i = 0; i < num.length() / 2; i++) {
                    if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                        ans = "no\n";
                        break;
                    }
                }
            }
            sb.append(ans);
        }
        System.out.println(sb.toString());
    }
}

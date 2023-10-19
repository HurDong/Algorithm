import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        char[] oi = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            oi[i] = s.charAt(i);
        }
        int count = 0;
        for (int i = 0; i < m - 2 * n; i++) {
            boolean correct = true;
            for (int j = 0; j < n; j++) {
                // 2n+1, 2n으로 나눈다
                // 2n == I 여야하고 2n+1 == O여야한다.
                if (oi[i + j * 2] != 'I' || oi[i + j * 2 + 1] != 'O') {
                    correct = false;
                    break;
                }
            }
            if (correct && oi[i + 2 * n] == 'I') {
                count++;
            }
        }
        System.out.println(count);
    }
}

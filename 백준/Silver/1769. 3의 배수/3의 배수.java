import java.util.Scanner;

public class Main {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        boolean isThree = findThree(n, 0);
        System.out.println(answer);
        System.out.println(isThree ? "YES" : "NO");
    }

    public static boolean findThree(String num, int count) {
        // 모든 자리 수의 합이 한자리일때 기저
        if (num.length() == 1) {
            answer = count;
            return Integer.parseInt(num) % 3 == 0; // 3의 배수인지 return
        }

        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }

        return findThree(String.valueOf(sum), count + 1);
    }
}

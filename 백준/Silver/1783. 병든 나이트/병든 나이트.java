import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 세로 길이
        int M = sc.nextInt(); // 가로 길이
        sc.close();
        
        // 결과를 저장할 변수
        int result = 0;

        if (N == 1) {
            result = 1;
        } else if (N == 2) {
            result = Math.min((M + 1) / 2, 4);
        } else if (M < 7) {
            result = Math.min(M, 4);
        } else {
            result = M - 2;
        }

        System.out.println(result);
    }
}
